package kz.gala.testing.repository.datajpa;

import kz.gala.testing.model.Question;
import kz.gala.testing.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaQuestionRepositoryImpl implements QuestionRepository {

    private final CrudQuestionRepository crudRepository;

    @Autowired
    public DataJpaQuestionRepositoryImpl(CrudQuestionRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public Question save(Question q) {
        return crudRepository.save(q);
    }

    @Override
    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }

    @Override
    public Question get(int id) {
        return crudRepository.findOne(id);
    }

    @Override
    public Integer getCorrectAnswerEnums(int id) {
        return get(id).getCorrectAnswerEnums();
    }

    @Override
    public List<Question> getAll(int themeId) {
        return crudRepository.getAll(themeId);
    }
}
