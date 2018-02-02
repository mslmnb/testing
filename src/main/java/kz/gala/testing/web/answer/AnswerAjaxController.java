package kz.gala.testing.web.answer;

import kz.gala.testing.model.Answer;
import kz.gala.testing.service.QuestionService;
import kz.gala.testing.to.AnswerTo;
import kz.gala.testing.service.AnswerService;
import kz.gala.testing.to.AnswerWithCorrect;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="ajax/admin/themes/{themeId}/questions/{questionId}/answers")
public class AnswerAjaxController extends AbstractAnswerController{

    public AnswerAjaxController(AnswerService answerService, QuestionService questionService) {
        super(answerService, questionService);
    }

    @Override
    @GetMapping(value="/{enumerator}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AnswerTo get(@PathVariable("questionId") int questionId, @PathVariable("enumerator") int enumerator) {
        return super.get(questionId, enumerator);
    }

    @Override
    @DeleteMapping(value="/{enumerator}")
    public void delete(@PathVariable("questionId") int questionId, @PathVariable("enumerator") int enumerator) {
        super.delete(questionId, enumerator);
    }

    @PostMapping
    public ResponseEntity<String> updateOrCreate (AnswerTo answerTo, BindingResult result, @PathVariable("questionId") int questionId) {
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
        if (answerTo.isNew()) {
            super.create(answerTo, questionId);
        } else {
            super.update(answerTo, answerTo.getId(), questionId);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AnswerWithCorrect> getAll(@PathVariable("questionId") int questionId) {
        return super.getAll(questionId);
    }

    @PostMapping(value = "/{enumerator}")
    public void correct(@PathVariable("questionId") int questionId, @PathVariable("enumerator") int enumerator, @RequestParam("correct") boolean correct) {
        super.correct(questionId, enumerator, correct);
    }



}
