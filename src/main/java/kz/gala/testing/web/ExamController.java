package kz.gala.testing.web;

import kz.gala.testing.AuthorizedUser;
import kz.gala.testing.model.Exam;
import kz.gala.testing.model.Question;
import kz.gala.testing.service.ExamService;
import kz.gala.testing.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Mussulmanbekova_GE on 15.06.2017.
 */
@RestController
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
        model.addAttribute("nextId", examList.get(1).getQuestionId());
        // проверка, если спсок пустой - бросать эксепшен
        return "exam";
    }

    @GetMapping(value="/last")
    public String getLast(Model model) {
        int userId = AuthorizedUser.id() ;
        List<Exam> examList = service.getLast(userId);
        Question currQuestion = questionService.get(examList.get(0).getQuestionId());
        model.addAttribute("question", currQuestion);
        model.addAttribute("previousId",examList.get(1).getQuestionId());
        // проверка, если спсок пустой - бросать эксепшен
        return "exam";
    }

    @GetMapping(value="/previous/{id}")
    public String getPrevious(@PathVariable("id") Integer id, Model model) {
        int userId = AuthorizedUser.id() ;
        List<Exam> examList = service.getPrevious(id, userId);
        model.addAttribute("question");
        // проверка, если спсок пустой - бросать эксепшен
        return "exam";
    }

    @GetMapping(value="/next/{id}")
    public String getNext(@PathVariable("id") Integer id, Model model) {
        int userId = AuthorizedUser.id() ;
        List<Exam> examList = service.getNext(id, userId);
        // проверка, если спсок пустой - бросать эксепшен
        return "exam";
    }
}
