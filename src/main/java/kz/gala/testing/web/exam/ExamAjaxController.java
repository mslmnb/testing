package kz.gala.testing.web.exam;

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
public class ExamAjaxController extends AbstractExamController {
    // создать AbstractExamController и наследоваться от него
    // посмотреть MealAjaxController.createOrUpdate - Spring binding

    @Autowired
    public ExamAjaxController(ExamService service, QuestionService questionService) {
        super(service, questionService);
    }


    @GetMapping(value="/first", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExamTo getFirst1() {
        ExamTo e = super.getFirst(null, null, null);
        return e;
    }


    @PostMapping(value="/first", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExamTo getFirst(@RequestParam("id") Integer id,
                           @RequestParam("userAnswerId") Integer userAnswerId,
                           @RequestParam("oldUserAnswerId") Integer oldUserAnswerId) {
        ExamTo e = super.getFirst(id, userAnswerId, oldUserAnswerId);
        return e;
    }

    @PostMapping(value="/next", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExamTo getNextFrom(@RequestParam("id") Integer id,
                              @RequestParam("userAnswerId") Integer userAnswerId,
                              @RequestParam("oldUserAnswerId") Integer oldUserAnswerId) {
        return super.getNextFrom(id, userAnswerId, oldUserAnswerId);
    }

    @PostMapping(value="/previous", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExamTo getPreviousFrom(@RequestParam("id") Integer id,
                                  @RequestParam("userAnswerId") Integer userAnswerId,
                                  @RequestParam("oldUserAnswerId") Integer oldUserAnswerId) {
        return super.getPreviousFrom(id, userAnswerId, oldUserAnswerId);
    }


    @PostMapping(value="/last", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExamTo getLast(@RequestParam("id") Integer id,
                          @RequestParam("userAnswerId") Integer userAnswerId,
                          @RequestParam("oldUserAnswerId") Integer oldUserAnswerId) {
        return super.getLast(id, userAnswerId, oldUserAnswerId);
    }

}
