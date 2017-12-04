package kz.gala.testing.web.exam;

import kz.gala.testing.model.Exam;
import kz.gala.testing.model.Question;
import kz.gala.testing.service.ExamService;
import kz.gala.testing.service.QuestionService;
import kz.gala.testing.to.ExamReport;
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

    public ExamTo getFirst(QuestionWithUserAnswer q, int userId) {
        log.info("getFirst");
        saveUserAnswer(q, userId);
        List<Exam> examList =  service.getFirst(userId); // первый и второй вопросы
        int currId = examList.get(0).getPrimaryKey().getQuestionId();
        int nextId = examList.get(1).getPrimaryKey().getQuestionId();
        Question currQuestion = questionService.get(currId);

        return new ExamTo(currQuestion, nextId, null, examList.get(0).getUserAnswerEnums());
    }

    public void saveUserAnswer(QuestionWithUserAnswer q, int userId) {
        if (q.isEdited()) {
            Integer questionId = q.getQuestionId();
            Integer userAnswerEnums = q.getUserAnswerEnums();
            if (questionId != null ) { // questionId == null попали на страницу впервые
                Exam exam = new Exam(userId, questionId, userAnswerEnums);
                log.info("update answers {} for question {} and user {}",
                        exam.getUserAnswerEnums(), exam.getPrimaryKey().getQuestionId(), exam.getPrimaryKey().getUserId());
                service.update(exam, userId);
            }
        }
    }

    public ExamTo getNextFrom(QuestionWithUserAnswer q, int userId) {
        log.info("getNextFrom {}", q.getQuestionId());
        saveUserAnswer(q, userId);
        List<Exam> examList = service.getNextFrom(q.getQuestionId(), userId);
        Integer prevId = examList.get(0).getPrimaryKey().getQuestionId();
        Integer currId = examList.get(1).getPrimaryKey().getQuestionId();
        Integer nextId = (examList.size()==2) ? null : examList.get(2).getPrimaryKey().getQuestionId();
        Question currQuestion = questionService.get(currId);

        return new ExamTo(currQuestion, nextId, prevId, examList.get(1).getUserAnswerEnums());
    }

    public ExamTo getPreviousFrom(QuestionWithUserAnswer q, int userId) {
        log.info("getPreviousFrom {}", q.getQuestionId());
        saveUserAnswer(q, userId);
        List<Exam> examList = service.getPreviousFrom(q.getQuestionId(), userId);
        Integer nextId = examList.get(0).getPrimaryKey().getQuestionId();
        Integer currId = examList.get(1).getPrimaryKey().getQuestionId();
        Integer prevId = (examList.size()==2) ? null : examList.get(2).getPrimaryKey().getQuestionId();
        Question currQuestion = questionService.get(currId);

        return new ExamTo(currQuestion, nextId, prevId,  examList.get(1).getUserAnswerEnums());
    }

    public ExamTo getLast(QuestionWithUserAnswer q, int userId) {
        log.info("getLast {}", q.getQuestionId());
        saveUserAnswer(q, userId);
        List<Exam> examList = service.getLast(userId);
        Integer currId = examList.get(0).getPrimaryKey().getQuestionId();
        Integer prevId = examList.get(1).getPrimaryKey().getQuestionId();
        Question currQuestion = questionService.get(currId);

        return new ExamTo(currQuestion, null, prevId, examList.get(0).getUserAnswerEnums());
    }

    public boolean isComplete(int userId) {
        return service.isComplete(userId);
    }

    public ExamReport getExamReport(int userId) {
        return service.getExamReport(userId);
    }
}
