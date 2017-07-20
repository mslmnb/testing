package kz.gala.testing.web.exam;

import kz.gala.testing.AuthorizedUser;
import kz.gala.testing.service.ExamService;
import kz.gala.testing.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("exam")
public class ExamController extends AbstractExamController{

    @Autowired
    public ExamController(ExamService service, QuestionService questionService) {
        super(service, questionService);
    }

    @GetMapping(value="/report")
    public String getUserReport(Model model) {
        model.addAttribute("userReport",super.getExamReport(AuthorizedUser.id()));
        return "report";
    }
}
