package kz.gala.testing.repository.jpa;

import kz.gala.testing.model.Exam;
import kz.gala.testing.model.ExamPrimaryKey;
import kz.gala.testing.repository.ExamRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaExamRepositoryImpl implements ExamRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Exam> getNextFrom(int questionId, int userId) {
        return em.createNamedQuery(Exam.NEXT, Exam.class)
                             .setParameter("questionId", questionId)
                             .setParameter("userId", userId)
                             .setMaxResults(3)
                             .getResultList();
    }

    @Override
    public List<Exam> getPreviousFrom(int questionId, int userId) {
        return em.createNamedQuery(Exam.PREVIOUS, Exam.class)
                             .setParameter("questionId", questionId)
                             .setParameter("userId", userId)
                             .setMaxResults(3)
                             .getResultList();
    }

    @Override
    public List<Exam> getFirst(int userId) {
        return em.createNamedQuery(Exam.FIRST, Exam.class)
                             .setParameter("userId", userId)
                             .setMaxResults(2)
                             .getResultList();
    }

    @Override
    public List<Exam> getLast(int userId) {
        return em.createNamedQuery(Exam.LAST, Exam.class)
                             .setParameter("userId", userId)
                             .setMaxResults(2)
                             .getResultList();
    }

    @Override
    public List<Exam> getAll(int userId) {
        return em.createNamedQuery(Exam.ALL, Exam.class)
                            .setParameter("userId", userId)
                            .getResultList();
    }

    @Override
    public Exam get(int questionId, int userId) {
        return em.find(Exam.class, new ExamPrimaryKey(userId, questionId));
    }

    @Override
    @Transactional
    public Exam update(Exam exam, int userAnswerId, int userId) {
        if (get(exam.getQuestionId(),userId)==null) {
            return null;
        }
        return  em.merge(new Exam(exam.getId(), userAnswerId));
    }
}
