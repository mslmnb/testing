package kz.gala.testing.web.answer;

import kz.gala.testing.model.Answer;
import kz.gala.testing.service.QuestionService;
import kz.gala.testing.to.AnswerTo;
import kz.gala.testing.service.AnswerService;
import kz.gala.testing.to.AnswerWithCorrect;
import kz.gala.testing.util.AnswerUtil;
import kz.gala.testing.web.admin.AbstractAdminController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static kz.gala.testing.util.AnswerUtil.createFromTo;
import static kz.gala.testing.util.ValidationUtil.checkIdConsistent;
import static kz.gala.testing.util.ValidationUtil.checkNew;


public abstract class AbstractAnswerController {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractAdminController.class);

    private final AnswerService answerService;
    private final QuestionService questionService;

    public AbstractAnswerController(AnswerService answerService, QuestionService questionService) {
        this.answerService = answerService;
        this.questionService = questionService;
    }

    public AnswerTo get(int questionId, int enumerator) {
        return AnswerUtil.asTo(answerService.get(questionId, enumerator));
    }

    public void delete(int questionId, int enumerator) {
        LOG.info("delete answer {} for question {}", enumerator, questionId);
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
        Answer updatedAnswer = createFromTo(answerTo, questionId);
        answerService.update(updatedAnswer);
    }

    public List<AnswerWithCorrect> getAll(int questionId) {
        LOG.info("get all answers for the question {}", questionId);
        // к каждому ответу необходимо добавить boolean признак isCorrect (верный или неверный ответ)
        return AnswerUtil.convertToListWithCorrect(answerService.getAll(questionId), questionService.get(questionId).getCorrectAnswerEnums());
    }

    public void correct(int questionId, int enumerator, boolean correct) {
        LOG.info("update correct value {} for the questionId {}, answer's enumerator {}", correct, questionId, enumerator);
        questionService.correct(questionId, enumerator, correct);
    }
}
