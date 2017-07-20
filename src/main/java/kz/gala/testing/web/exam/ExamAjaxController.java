package kz.gala.testing.web.exam;

import kz.gala.testing.AuthorizedUser;
import kz.gala.testing.model.Exam;
import kz.gala.testing.model.Question;
import kz.gala.testing.service.ExamService;
import kz.gala.testing.service.QuestionService;
import kz.gala.testing.to.ExamReport;
import kz.gala.testing.to.ExamTo;
import kz.gala.testing.to.QuestionWithUserAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ajax/exam")
public class ExamAjaxController extends AbstractExamController {

    @Autowired
    public ExamAjaxController(ExamService service, QuestionService questionService) {
        super(service, questionService);
    }

    @PostMapping(value="/first", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExamTo getFirst(QuestionWithUserAnswer q) {
        return super.getFirst(q, AuthorizedUser.id());
    }

    @PostMapping(value="/next", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExamTo getNextFrom(QuestionWithUserAnswer q) {
        return super.getNextFrom(q, AuthorizedUser.id());
    }

    @PostMapping(value="/previous", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExamTo getPreviousFrom(QuestionWithUserAnswer q) {
        return super.getPreviousFrom(q, AuthorizedUser.id());
    }


    @PostMapping(value="/last", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExamTo getLast(QuestionWithUserAnswer q) {
        return super.getLast(q, AuthorizedUser.id());
    }

    @PostMapping(value="/report", produces = MediaType.APPLICATION_JSON_VALUE)
    public void finishTest(QuestionWithUserAnswer q) {
        super.saveUserAnswer(q, AuthorizedUser.id());
    }
}
