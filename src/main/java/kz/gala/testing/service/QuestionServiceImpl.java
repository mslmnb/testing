package kz.gala.testing.service;

import kz.gala.testing.util.exception.NotFoundException;
import kz.gala.testing.model.Question;
import kz.gala.testing.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static kz.gala.testing.util.ValidationUtil.checkNotFoundWithId;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository repository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public Question save(Question question) {
        Assert.notNull(question, "question must not be null");  //throws IllegalArgumentException
        return repository.save(question);
    }

    @Override
    public Question update(Question question) throws NotFoundException {
        Assert.notNull(question, "question must not be null");  //throws IllegalArgumentException
        return checkNotFoundWithId(repository.save(question), question.getId());
    }

    @Override
    public List<Question> getAll(int themeId) {
        return repository.getAll(themeId);
    }

    @Override
    public void correct(Integer questionId, Integer enumerator, Boolean correct) {

        Assert.notNull(enumerator, "enumerator must not be null");  //throws IllegalArgumentException
        Assert.notNull(questionId, "questionId must not be null");  //throws IllegalArgumentException
        Assert.notNull(correct, "correct must not be null");
        //откорректировать в соответствии со значением isCorrect поле question.correct_answer_enum
        Question q = repository.get(questionId);
        Integer correctAnswerEnums = q.getCorrectAnswerEnums();
        int mask = (int) Math.pow(2, enumerator);
        // устанавливаю единицу в позиции enumerator
        correctAnswerEnums = correctAnswerEnums | mask;
        if (!correct) {
            // устанавливаю ноль в позиции enumerator
            correctAnswerEnums = correctAnswerEnums ^ mask;
        }
        q.setCorrectAnswerEnums(correctAnswerEnums);
        repository.save(q);
    }

}
