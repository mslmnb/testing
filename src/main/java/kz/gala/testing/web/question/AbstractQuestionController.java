package kz.gala.testing.web.question;

import kz.gala.testing.Profiles;
import kz.gala.testing.model.BaseEntity;
import kz.gala.testing.model.Question;
import kz.gala.testing.service.QuestionService;
import kz.gala.testing.to.QuestionTo;
import kz.gala.testing.util.exception.ApplicationException;
import kz.gala.testing.web.ExceptionInfoHandler;
import kz.gala.testing.web.theme.AbstractThemeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;

import java.util.List;

import static kz.gala.testing.util.QuestionUtil.asTo;
import static kz.gala.testing.util.QuestionUtil.convertToListQuestionTo;
import static kz.gala.testing.util.ValidationUtil.checkIdConsistent;
import static kz.gala.testing.util.ValidationUtil.checkNew;

public abstract class AbstractQuestionController {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractThemeController.class);

    public static final String EXCEPTION_MODIFICATION_RESTRICTION = "exception.question.modificationRestriction";

    private final QuestionService questionService;
    @Autowired
    private ExceptionInfoHandler exceptionInfoHandler;

    private boolean modificationRestriction;

    @Autowired
    public void setEnvironment(Environment environment) {
        modificationRestriction = environment.acceptsProfiles(Profiles.HEROKU);
    }


    public AbstractQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    public QuestionTo getTo(int id, int themeId) {
        return asTo(questionService.get(id, themeId));
    }

    public Question get(int id, int themeId) {
        LOG.info("get question {}", id);
        return questionService.get(id, themeId);
    }
    public void delete(int id, int themeId) {
        LOG.info("delete question {}", id);
        checkModificationAllowed(id);
        questionService.delete(id, themeId);
    }

    public Question create(Question q, int themeId) {
        LOG.info("create question{} for the theme {}", q, themeId);
        checkNew(q);
        return questionService.save(q, themeId);
    }

    public void update(Question q, int themeId, int id) {
        LOG.info("update question with id={} from {} for the theme {}", id, q, themeId);
        checkIdConsistent(q, id);
        checkModificationAllowed(id);
        questionService.update(q, themeId);
    }

    public List<QuestionTo> getAll(int themeId) {
        LOG.info("get all questions for the theme {}", themeId);
        return convertToListQuestionTo(questionService.getAll(themeId));
    }

    private void checkModificationAllowed(int id) {
        if(modificationRestriction && id > BaseEntity.START_SEQ + 19 && id < BaseEntity.START_SEQ + 29 ) {
            throw new ApplicationException(EXCEPTION_MODIFICATION_RESTRICTION, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
        }
    }

}
