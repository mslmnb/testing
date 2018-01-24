package kz.gala.testing.repository.datajpa;

import kz.gala.testing.model.Answer;
import kz.gala.testing.model.AnswerPrimaryKey;
import kz.gala.testing.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class DataJpaAnswerRepositoryImpl implements AnswerRepository{

    private final CrudAnswerRepository crudRepository;

  @Autowired
    public DataJpaAnswerRepositoryImpl(CrudAnswerRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public Answer save(Answer a) {
        return crudRepository.save(a);
    }

    @Override
    public boolean delete(int questionId, int enumerator) {
        return crudRepository.delete(questionId, enumerator)!=0;
    }

    @Override
    public Answer get(int questionId, int enumerator) {
        Answer a = crudRepository.findOne(new AnswerPrimaryKey(questionId, enumerator));
        return a;
    }

    @Override
    public List<Answer> getAll(int questionId) {
        return crudRepository.getAll(questionId);
    }

}
