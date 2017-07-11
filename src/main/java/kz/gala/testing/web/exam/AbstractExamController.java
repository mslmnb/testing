package kz.gala.testing.web.exam;

import kz.gala.testing.AuthorizedUser;
import kz.gala.testing.model.Exam;
import kz.gala.testing.model.Question;
import kz.gala.testing.service.ExamService;
import kz.gala.testing.service.QuestionService;
import kz.gala.testing.to.ExamTo;
import org.slf4j.LoggerFactory;

import java.util.List;

abstract public class AbstractExamController {
    protected final org.slf4j.Logger log = LoggerFactory.getLogger(getClass());
    private ExamService service;
    private QuestionService questionService;

    public AbstractExamController(ExamService service, QuestionService questionService) {
        this.service = service;
        this.questionService = questionService;
    }

    public ExamTo getFirst(Integer id, Integer userAnswerId, boolean edited) {
        log.info("getFirst");
        int userId = AuthorizedUser.id() ;
        saveUserAnswer(id, userAnswerId, userId, edited);
        List<Exam> examList =  service.getFirst(userId); // первый и второй вопросы
        int currId = examList.get(0).getQuestionId();
        int nextId = examList.get(1).getQuestionId();
        Question currQuestion = questionService.get(currId);

        return new ExamTo(currId, currQuestion.getBody(), currQuestion.getAnswers(), nextId, null, examList.get(0).getUserAnswerId());
    }

    private void saveUserAnswer(Integer questionId, Integer userAnswerId, int userId, boolean edited) {
        if (edited) {
            log.info("update answer {} for question {} and user {}", userAnswerId, questionId, userId);
            if (questionId != null && userAnswerId != null) {
                Exam exam = new Exam(questionId, userId, null);
                service.update(exam, userAnswerId, userId);
            }
        }
    }

    public ExamTo getNextFrom(Integer id, Integer userAnswerId, boolean edited) {
        log.info("getNextFrom {}", id);
        int userId = AuthorizedUser.id() ;
        saveUserAnswer(id, userAnswerId, userId, edited);
        List<Exam> examList = service.getNextFrom(id, userId);
        Integer prevId = examList.get(0).getQuestionId();
        Integer currId = examList.get(1).getQuestionId();
        Integer nextId = (examList.size()==2) ? null : examList.get(2).getQuestionId();
        Question currQuestion = questionService.get(currId);

        return new ExamTo(currId, currQuestion.getBody(), currQuestion.getAnswers(), nextId, prevId, examList.get(1).getUserAnswerId());
    }

    public ExamTo getPreviousFrom(Integer id, Integer userAnswerId, boolean edited) {
        log.info("getPreviousFrom {}", id);
        int userId = AuthorizedUser.id() ;
        saveUserAnswer(id, userAnswerId, userId, edited);
        List<Exam> examList = service.getPreviousFrom(id, userId);
        Integer nextId = examList.get(0).getQuestionId();
        Integer currId = examList.get(1).getQuestionId();
        Integer prevId = (examList.size()==2) ? null : examList.get(2).getQuestionId();
        Question currQuestion = questionService.get(currId);

        return new ExamTo(currId, currQuestion.getBody(), currQuestion.getAnswers(), nextId, prevId,  examList.get(1).getUserAnswerId());
    }

    public ExamTo getLast(Integer id, Integer userAnswerId, boolean edited) {
        log.info("getLast {}", id);
        int userId = AuthorizedUser.id() ;
        saveUserAnswer(id, userAnswerId, userId, edited);
        List<Exam> examList = service.getLast(userId);
        Integer currId = examList.get(0).getQuestionId();
        Integer prevId = examList.get(1).getQuestionId();
        Question currQuestion = questionService.get(examList.get(0).getQuestionId());

        return new ExamTo(currId, currQuestion.getBody(), currQuestion.getAnswers(), null, prevId, examList.get(0).getUserAnswerId());
    }


}
