package kz.gala.testing.repository.jpa;

import kz.gala.testing.model.Question;
import kz.gala.testing.repository.QuestionRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional(readOnly = true)
public class JpaQuestionRepositoryImpl implements QuestionRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    public Question save(Question question) {

        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Question get(int id) {
        return em.find(Question.class, id);
    }
}
