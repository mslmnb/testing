package kz.gala.testing.web.exam;

import kz.gala.testing.AuthorizedUser;
import kz.gala.testing.model.Exam;
import kz.gala.testing.model.Question;
import kz.gala.testing.service.ExamService;
import kz.gala.testing.service.QuestionService;
import kz.gala.testing.to.ExamTo;
import kz.gala.testing.to.QuestionWithUserAnswer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

abstract public class AbstractExamController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private ExamService service;
    private QuestionService questionService;

    public AbstractExamController(ExamService service, QuestionService questionService) {
        this.service = service;
        this.questionService = questionService;
    }

    public ExamTo getFirst(QuestionWithUserAnswer q) {
        log.info("getFirst");
        int userId = AuthorizedUser.id() ;
        saveUserAnswer(q, userId);
        List<Exam> examList =  service.getFirst(userId); // первый и второй вопросы
        int currId = examList.get(0).getQuestionId();
        int nextId = examList.get(1).getQuestionId();
        Question currQuestion = questionService.get(currId);

        return new ExamTo(currQuestion, currQuestion.getAnswers(), nextId, null, examList.get(0).getUserAnswerId());
    }

    private void saveUserAnswer(QuestionWithUserAnswer q, int userId) {
        if (q.isEdited()) {
            Integer questionId = q.getQuestionId();
            Integer userAnswerId = q.getUserAnswerId();
            if (questionId != null && userAnswerId != null) { // questionId == null попали на страницу впервые, userAnswerId == null - пользователь не давал ответ
                log.info("update answer {} for question {} and user {}", userAnswerId, questionId, userId);
                Exam exam = new Exam(questionId, userId, null);
                service.update(exam, userAnswerId, userId);
            }
        }
    }

    public ExamTo getNextFrom(QuestionWithUserAnswer q) {
        log.info("getNextFrom {}", q.getQuestionId());
        int userId = AuthorizedUser.id() ;
        saveUserAnswer(q, userId);
        List<Exam> examList = service.getNextFrom(q.getQuestionId(), userId);
        Integer prevId = examList.get(0).getQuestionId();
        Integer currId = examList.get(1).getQuestionId();
        Integer nextId = (examList.size()==2) ? null : examList.get(2).getQuestionId();
        Question currQuestion = questionService.get(currId);

        return new ExamTo(currQuestion, currQuestion.getAnswers(), nextId, prevId, examList.get(1).getUserAnswerId());
    }

    public ExamTo getPreviousFrom(QuestionWithUserAnswer q) {
        log.info("getPreviousFrom {}", q.getQuestionId());
        int userId = AuthorizedUser.id() ;
        saveUserAnswer(q, userId);
        List<Exam> examList = service.getPreviousFrom(q.getQuestionId(), userId);
        Integer nextId = examList.get(0).getQuestionId();
        Integer currId = examList.get(1).getQuestionId();
        Integer prevId = (examList.size()==2) ? null : examList.get(2).getQuestionId();
        Question currQuestion = questionService.get(currId);

        return new ExamTo(currQuestion, currQuestion.getAnswers(), nextId, prevId,  examList.get(1).getUserAnswerId());
    }

    public ExamTo getLast(QuestionWithUserAnswer q) {
        log.info("getLast {}", q.getQuestionId());
        int userId = AuthorizedUser.id() ;
        saveUserAnswer(q, userId);
        List<Exam> examList = service.getLast(userId);
        Integer currId = examList.get(0).getQuestionId();
        Integer prevId = examList.get(1).getQuestionId();
        Question currQuestion = questionService.get(examList.get(0).getQuestionId());

        return new ExamTo(currQuestion, currQuestion.getAnswers(), null, prevId, examList.get(0).getUserAnswerId());
    }

}
