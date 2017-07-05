package kz.gala.testing.web;

import kz.gala.testing.AuthorizedUser;
import kz.gala.testing.model.Exam;
import kz.gala.testing.model.Question;
import kz.gala.testing.service.ExamService;
import kz.gala.testing.service.QuestionService;
import kz.gala.testing.to.ExamTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Mussulmanbekova_GE on 22.06.2017.
 */
@RestController
@RequestMapping("ajax/exam")     // завести константу
public class ExamAjaxController {
    // создать AbstractExamController и наследоваться от него
    // посмотреть MealAjaxController.createOrUpdate - Spring binding
    private ExamService service;
    private QuestionService questionService;

    @Autowired
    public ExamAjaxController(ExamService service, QuestionService questionService) {
        this.service = service;
        this.questionService = questionService;
    }

    @PostMapping(value="/first", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExamTo getFirst(@RequestParam("id") Integer id, @RequestParam("userAnswerId") Integer userAnswerId) {
        int userId = AuthorizedUser.id() ;
        saveUserAnswer(id, userAnswerId, userId);
        List<Exam> examList =  service.getFirst(userId); // первый и второй вопросы
        int currId = examList.get(0).getQuestionId();
        int nextId = examList.get(1).getQuestionId();
        Question currQuestion = questionService.get(currId);

        return new ExamTo(currId, currQuestion.getBody(), currQuestion.getAnswers(), nextId, null, examList.get(0).getUserAnswerId());
    }

    private void saveUserAnswer(Integer questionId, Integer userAnswerId, int userId) {
        if (questionId!=null && userAnswerId!=null) {
            Exam exam = new Exam(questionId,  userId, null);
            service.update(exam, userAnswerId, userId);
        }
    }

    @PostMapping(value="/next", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExamTo getNextFrom(@RequestParam("id") Integer id, @RequestParam("userAnswerId") Integer userAnswerId) {
        int userId = AuthorizedUser.id() ;
        saveUserAnswer(id, userAnswerId, userId);
        List<Exam> examList = service.getNextFrom(id, userId);
        Integer prevId = examList.get(0).getQuestionId();
        Integer currId = examList.get(1).getQuestionId();
        Integer nextId = (examList.size()==2) ? null : examList.get(2).getQuestionId();
        Question currQuestion = questionService.get(currId);

        return new ExamTo(currId, currQuestion.getBody(), currQuestion.getAnswers(), nextId, prevId, examList.get(1).getUserAnswerId());
    }

    @PostMapping(value="/previous", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExamTo getPreviousFrom(@RequestParam("id") Integer id, @RequestParam("userAnswerId") Integer userAnswerId) {
        int userId = AuthorizedUser.id() ;
        saveUserAnswer(id, userAnswerId, userId);
        List<Exam> examList = service.getPreviousFrom(id, userId);
        Integer nextId = examList.get(0).getQuestionId();
        Integer currId = examList.get(1).getQuestionId();
        Integer prevId = (examList.size()==2) ? null : examList.get(2).getQuestionId();
        Question currQuestion = questionService.get(currId);

        // проверка, если спсок пустой - бросать эксепшен
        return new ExamTo(currId, currQuestion.getBody(), currQuestion.getAnswers(), nextId, prevId,  examList.get(1).getUserAnswerId());
    }


    @PostMapping(value="/last", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExamTo getLast(@RequestParam("id") Integer id, @RequestParam("userAnswerId") Integer userAnswerId) {
        int userId = AuthorizedUser.id() ;
        saveUserAnswer(id, userAnswerId, userId);
        List<Exam> examList = service.getLast(userId);
        Integer currId = examList.get(0).getQuestionId();
        Integer prevId = examList.get(1).getQuestionId();
        Question currQuestion = questionService.get(examList.get(0).getQuestionId());

        // проверка, если спсок пустой - бросать эксепшен
        return new ExamTo(currId, currQuestion.getBody(), currQuestion.getAnswers(), null, prevId, examList.get(0).getUserAnswerId());
    }

}
