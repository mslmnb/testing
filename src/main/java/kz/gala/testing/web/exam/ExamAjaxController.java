package kz.gala.testing.web.exam;

import kz.gala.testing.AuthorizedUser;
import kz.gala.testing.service.ExamService;
import kz.gala.testing.service.QuestionService;
import kz.gala.testing.to.ExamTo;
import kz.gala.testing.to.QuestionWithUserAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ajax/exam")
public class ExamAjaxController extends AbstractExamController {

    @Autowired
    public ExamAjaxController(ExamService service, QuestionService questionService) {
        super(service, questionService);
    }

    @PostMapping(value="/first", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExamTo getFirst(@RequestBody QuestionWithUserAnswer q) {
        return super.getFirst(q, AuthorizedUser.id(), AuthorizedUser.themeId());
    }

    @PostMapping(value="/next", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExamTo getNextFrom(@RequestBody QuestionWithUserAnswer q) {
        return super.getNextFrom(q, AuthorizedUser.id(), AuthorizedUser.themeId());
    }
    @PostMapping(value="/previous", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExamTo getPreviousFrom(@RequestBody QuestionWithUserAnswer q) {
        return super.getPreviousFrom(q, AuthorizedUser.id(), AuthorizedUser.themeId());
    }


    @PostMapping(value="/last", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExamTo getLast(@RequestBody QuestionWithUserAnswer q) {
        return super.getLast(q, AuthorizedUser.id(), AuthorizedUser.themeId());
    }

    @PostMapping(value="/report", produces = MediaType.APPLICATION_JSON_VALUE)
    public void finishTest(@RequestBody QuestionWithUserAnswer q) {
        super.saveUserAnswer(q, AuthorizedUser.id());
    }
}
