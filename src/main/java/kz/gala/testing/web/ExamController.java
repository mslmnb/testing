package kz.gala.testing.web;

import kz.gala.testing.AuthorizedUser;
import kz.gala.testing.model.Exam;
import kz.gala.testing.model.Question;
import kz.gala.testing.service.ExamService;
import kz.gala.testing.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Mussulmanbekova_GE on 15.06.2017.
 */
@Controller
@RequestMapping(value = "/exam")
public class ExamController {

    private ExamService service;
    private QuestionService questionService;

    @Autowired
    public ExamController(ExamService service, QuestionService questionService) {
        this.service = service;
        this.questionService = questionService;
    }

    @GetMapping(value="/first")
    public String getFirst(Model model) {
        int userId = AuthorizedUser.id() ;
        List<Exam> examList =  service.getFirst(userId);
        Question currQuestion = questionService.get(examList.get(0).getQuestionId());
        model.addAttribute("question", currQuestion);
        if (examList.size()==2) {
            model.addAttribute("nextId", true);
        }
        // проверка, если спсок пустой - бросать эксепшен
        return "exam";
    }

    @GetMapping(value="/last")
    public String getLast(Model model) {
        int userId = AuthorizedUser.id() ;
        List<Exam> examList = service.getLast(userId);
        Question currQuestion = questionService.get(examList.get(0).getQuestionId());
        model.addAttribute("question", currQuestion);
        if (examList.size()==2) {
            model.addAttribute("prevId", true);
        }
        // проверка, если спсок пустой - бросать эксепшен
        return "exam";
    }

    @PostMapping(value="/previous/{id}")
    public String getPreviousFrom(@PathVariable("id") Integer id, Model model) {
        int userId = AuthorizedUser.id() ;
        List<Exam> examList = service.getPreviousFrom(id, userId);
        Question currQuestion = questionService.get(examList.get(1).getQuestionId());
        model.addAttribute("question", currQuestion)
             .addAttribute("nextId", true);
        if (examList.size()==3) {
            model.addAttribute("prevId", true);
        } else {
            model.addAttribute("prevId", false);
        }
        // проверка, если спсок пустой - бросать эксепшен
        return "exam";
    }

    @PostMapping(value="/next/{id}")
    public String getNextFrom(@PathVariable("id") Integer id, Model model) {
        int userId = AuthorizedUser.id() ;
        List<Exam> examList = service.getNextFrom(id, userId);
        Question currQuestion = questionService.get(examList.get(1).getQuestionId());
        model.addAttribute("question", currQuestion)
                .addAttribute("prevId", true);
        if (examList.size()==3) {
             model.addAttribute("nextId", true);
        } else {
            model.addAttribute("nextId", false);
        }

        // проверка, если спсок пустой - бросать эксепшен
        return "exam";
    }
}
