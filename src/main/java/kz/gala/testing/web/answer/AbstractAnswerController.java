package kz.gala.testing.web.answer;

import kz.gala.testing.Profiles;
import kz.gala.testing.model.Answer;
import kz.gala.testing.model.BaseEntity;
import kz.gala.testing.service.QuestionService;
import kz.gala.testing.to.AnswerTo;
import kz.gala.testing.service.AnswerService;
import kz.gala.testing.to.AnswerWithCorrect;
import kz.gala.testing.util.AnswerUtil;
import kz.gala.testing.util.exception.ApplicationException;
import kz.gala.testing.web.ExceptionInfoHandler;
import kz.gala.testing.web.theme.AbstractThemeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;

import java.util.List;

import static kz.gala.testing.util.AnswerUtil.createFromTo;
import static kz.gala.testing.util.ValidationUtil.checkIdConsistent;
import static kz.gala.testing.util.ValidationUtil.checkNew;


public abstract class AbstractAnswerController {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractThemeController.class);

    public static final String EXCEPTION_MODIFICATION_RESTRICTION = "exception.answer.modificationRestriction";

    private final AnswerService answerService;
    private final QuestionService questionService;

    @Autowired
    private ExceptionInfoHandler exceptionInfoHandler;

    private boolean modificationRestriction;

    @Autowired
    public void setEnvironment(Environment environment) {
        modificationRestriction = environment.acceptsProfiles(Profiles.HEROKU);
    }


    public AbstractAnswerController(AnswerService answerService, QuestionService questionService) {
        this.answerService = answerService;
        this.questionService = questionService;
    }

    public AnswerTo get(int questionId, int enumerator) {
        return AnswerUtil.asTo(answerService.get(questionId, enumerator));
    }

    public void delete(int questionId, int enumerator) {
        LOG.info("deleteAllFor answer {} for question {}", enumerator, questionId);
        checkModificationAllowed(questionId);
        answerService.delete(questionId, enumerator);
    }

    public Answer create(AnswerTo answerTo, int questionId) {
        LOG.info("create answer from answerTo {} for a question {}", answerTo, questionId);
        checkNew(answerTo);
        Answer newAnswer = createFromTo(answerTo, questionId);
        return answerService.save(newAnswer, questionId);
    }

    public void update(AnswerTo answerTo, int enumerator,  int questionId) {
        LOG.info("update answer from answerTo {} for a question {} with isCorrect = {}", answerTo, questionId);
        checkIdConsistent(answerTo, enumerator);
        checkModificationAllowed(questionId);
        Answer updatedAnswer = createFromTo(answerTo, questionId);
        answerService.update(updatedAnswer);
    }

    public List<AnswerWithCorrect> getAll(int questionId, int themeId) {
        LOG.info("get all answers for the question {}", questionId);
        // к каждому ответу необходимо добавить boolean признак isCorrect (верный или неверный ответ)
        return AnswerUtil.convertToListWithCorrect(answerService.getAll(questionId), questionService.get(questionId, themeId).getCorrectAnswerEnums());
    }

    public void correct(int questionId, int themeId, int enumerator, boolean correct) {
        LOG.info("update correct value {} for the questionId {}, answer's enumerator {}", correct, questionId, enumerator);
        checkModificationAllowed(questionId);
        questionService.correct(questionId, themeId, enumerator, correct);
    }

    private void checkModificationAllowed(int id) {
        if(modificationRestriction && id > BaseEntity.START_SEQ + 19 && id < BaseEntity.START_SEQ + 29 ) {
            throw new ApplicationException(EXCEPTION_MODIFICATION_RESTRICTION, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
        }
    }

}
