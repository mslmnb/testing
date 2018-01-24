package kz.gala.testing.service;

import kz.gala.testing.model.Answer;
import kz.gala.testing.model.AnswerPrimaryKey;
import kz.gala.testing.model.Question;
import kz.gala.testing.repository.AnswerRepository;
import kz.gala.testing.repository.QuestionRepository;
import kz.gala.testing.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

import static kz.gala.testing.util.ValidationUtil.checkNotFoundWithIds;

@Service
public class AnswerServiceImpl implements AnswerService{

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public Answer get(int questionId, int enumerator) throws NotFoundException {
        return checkNotFoundWithIds(answerRepository.get(questionId, enumerator),questionId, enumerator);
    }

    @Override
    public void delete(int questionId, int enumerator) throws NotFoundException {
        checkNotFoundWithIds(answerRepository.delete(questionId, enumerator),questionId, enumerator);
    }

    @Override
    @Transactional
    public Answer save(Answer a, Integer questionId) {
        Assert.notNull(a, "answer must not be null");
        Assert.notNull(questionId, "questionId must not be null");
        int enumerator = getAll(questionId).size();
        a.setPrimaryKey(new AnswerPrimaryKey(questionId, enumerator));
        return answerRepository.save(a);
    }

    @Override
    @Transactional
    public Answer update(Answer a) throws NotFoundException {
        Assert.notNull(a, "answer must not be null");
        int questionId = a.getQuestionId();
        int enumerator = a.getEnumerator();
        return checkNotFoundWithIds(answerRepository.save(a),questionId,a.getEnumerator());
    }

    @Override
    public List<Answer> getAll(int questionId) {
        return answerRepository.getAll(questionId);
    }

}
