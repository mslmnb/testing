package kz.gala.testing.service;

import kz.gala.testing.util.exception.NotFoundException;
import kz.gala.testing.model.Question;
import kz.gala.testing.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static kz.gala.testing.util.ValidationUtil.checkNotFoundWithId;
import static kz.gala.testing.util.ValidationUtil.checkNotFoundWithIds;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository repository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question get(int id, int themeId) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id, themeId), id);
    }

    @Override
    public void delete(int id, int themeId) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id, themeId), id);
    }

    @Override
    public Question save(Question question, int themeId) {
        Assert.notNull(question, "question must not be null");  //throws IllegalArgumentException
        return repository.save(question, themeId);
    }

    @Override
    public Question update(Question question, int themeId) throws NotFoundException {
        Assert.notNull(question, "question must not be null");  //throws IllegalArgumentException
        return checkNotFoundWithIds(repository.save(question, themeId), themeId, question.getId());
    }

    @Override
    public List<Question> getAll(int themeId) {
        return repository.getAll(themeId);
    }

    @Override
    public void correct(int questionId, int themeId, int enumerator, boolean correct) {

        //откорректировать в соответствии со значением isCorrect поле question.correct_answer_enum
        Question q = repository.get(questionId, themeId);
        Integer correctAnswerEnums = q.getCorrectAnswerEnums();
        int mask = (int) Math.pow(2, enumerator);
        // устанавливаю единицу в позиции enumerator
        correctAnswerEnums = correctAnswerEnums | mask;
        if (!correct) {
            // устанавливаю ноль в позиции enumerator
            correctAnswerEnums = correctAnswerEnums ^ mask;
        }
        q.setCorrectAnswerEnums(correctAnswerEnums);
        repository.save(q, themeId);
    }

}
