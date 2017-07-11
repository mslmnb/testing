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

    @PostMapping(value="/first", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExamTo getFirst(@RequestParam("id") Integer id,
                           @RequestParam("userAnswerId") Integer userAnswerId,
                           @RequestParam("edited") boolean edited) {
        return super.getFirst(id, userAnswerId, edited);
    }

    @PostMapping(value="/next", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExamTo getNextFrom(@RequestParam("id") Integer id,
                              @RequestParam("userAnswerId") Integer userAnswerId,
                              @RequestParam("edited") boolean edited) {
        return super.getNextFrom(id, userAnswerId, edited);
    }

    @PostMapping(value="/previous", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExamTo getPreviousFrom(@RequestParam("id") Integer id,
                                  @RequestParam("userAnswerId") Integer userAnswerId,
                                  @RequestParam("edited") boolean edited) {
        return super.getPreviousFrom(id, userAnswerId, edited);
    }


    @PostMapping(value="/last", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExamTo getLast(@RequestParam("id") Integer id,
                          @RequestParam("userAnswerId") Integer userAnswerId,
                          @RequestParam("edited") boolean edited) {
        return super.getLast(id, userAnswerId, edited);
    }

}
