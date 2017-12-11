package kz.gala.testing.web.question;

import kz.gala.testing.model.Question;
import kz.gala.testing.model.Theme;
import kz.gala.testing.service.QuestionService;
import kz.gala.testing.to.QuestionTo;
import kz.gala.testing.web.admin.AbstractAdminController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

import static kz.gala.testing.util.ValidationUtil.checkIdConsistent;
import static kz.gala.testing.util.ValidationUtil.checkNew;

public abstract class AbstractQuestionController {

//    @GetMapping(value="/{id}/questions/", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Question> getQuestions(@PathVariable("id") int id) {
//
//    }

    private static final Logger LOG = LoggerFactory.getLogger(AbstractAdminController.class);

    private final QuestionService questionService;


    public AbstractQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    public QuestionTo getTo(int id) {
        LOG.info("get question {}", id);
        return new QuestionTo(questionService.get(id));
    }

    public Question get(int id) {
        LOG.info("get question {}", id);
        return questionService.get(id);
    }
    public void delete(int id) {
        LOG.info("delete question {}", id);
        questionService.delete(id);
    }

    public Question create(Question q) {
        LOG.info("create {}", q);
        checkNew(q);
        return questionService.save(q);
    }

    public void update(Question q, int id) {
        LOG.info("update {} with id={}", q, id);
        checkIdConsistent(q, id);
        questionService.update(q);
    }

    public List<QuestionTo> getAll(int themeId) {
        LOG.info("get all question for the theme {}", themeId);
        return questionService.getAll(themeId).stream().map(q->new QuestionTo(q)).collect(Collectors.toList());
    }


}
