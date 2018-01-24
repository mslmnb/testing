package kz.gala.testing.web.admin;

import kz.gala.testing.model.Theme;
import kz.gala.testing.service.ExamService;
import kz.gala.testing.service.QuestionService;
import kz.gala.testing.web.exam.AbstractExamController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController { // extends AbstractExamController

    //public AdminController(ExamService service, QuestionService questionService) {
//        super(service, questionService);
//    }

    @GetMapping(value = "/themes")
    public String themes(Model model) {
        return "themes";
    }

    @GetMapping(value="/themes/{themeId}/questions")
    public String questions(Model model, @PathVariable("themeId") int themeId) {
        model.addAttribute("themeId", themeId);
        return "questions";
    }

    @GetMapping(value="/themes/{themeId}/questions/{questionId}/answers")
    public String answers(Model model, @PathVariable("themeId") int themeId, @PathVariable("questionId") int questionId) {
        model.addAttribute("themeId", themeId);
        model.addAttribute("questionId", questionId);
        return "answers";
    }

//    @GetMapping(value="/themes/users/{id}")
//    public String users(Model model, @PathVariable("id") int id) {
//        model.addAttribute("themesId", id);
//        return "users";
//    }
}
