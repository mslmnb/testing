package kz.gala.testing.web.question;

import kz.gala.testing.model.Question;
import kz.gala.testing.model.Theme;
import kz.gala.testing.service.QuestionService;
import kz.gala.testing.to.QuestionTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="ajax/admin/themes/{themeId}/questions/")
public class QuestionAjaxController extends AbstractQuestionController {
    public QuestionAjaxController(QuestionService questionService) {
        super(questionService);
    }


    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<QuestionTo> getAll(@PathVariable("themeId") int themeId) {
        return super.getAll(themeId);
    }

    @Override
    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public QuestionTo getTo(@PathVariable("id") int id) {
        return super.getTo(id);
    }

    @Override
    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @PostMapping
    public ResponseEntity<String> updateOrCreate (Question question, BindingResult result, @PathVariable("themeId") int themeId) {
        if (result.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            result.getFieldErrors()
                    .forEach(fe -> sb.append(fe.getField())
                            .append(" ")
                            .append(fe.getDefaultMessage())
                            .append("<br>")
                    );
            return new ResponseEntity<>(sb.toString(), HttpStatus.UNPROCESSABLE_ENTITY);

        }
        question.setTheme(new Theme(themeId));
        if (question.isNew()) {
            question.setCorrectAnswerEnums(0);
            super.create(question);
        } else {
            Question questionFromDb = super.get(question.getId());
            question.setCorrectAnswerEnums(questionFromDb.getCorrectAnswerEnums());
            super.update(question, question.getId());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
