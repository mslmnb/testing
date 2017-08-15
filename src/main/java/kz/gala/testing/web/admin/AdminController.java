package kz.gala.testing.web.admin;

import kz.gala.testing.service.ExamService;
import kz.gala.testing.service.QuestionService;
import kz.gala.testing.web.exam.AbstractExamController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController extends AbstractExamController{

    public AdminController(ExamService service, QuestionService questionService) {
        super(service, questionService);
    }

    @GetMapping(value = "/themes")
    public String themes(Model model) {
        return "themes";
    }

    @GetMapping(value="/themes/answers")
    public String answers(Model model) {
        return "answers";
    }

    @GetMapping(value="/themes/users")
    public String users(Model model) {
        return "users";
    }
}
