package kz.gala.testing.repository.jpa;

import kz.gala.testing.model.Exam;
import kz.gala.testing.repository.ExamRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Mussulmanbekova_GE on 15.06.2017.
 */
@Repository
@Transactional(readOnly = true)
public class JpaExamRepositoryImpl implements ExamRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Exam> getNext(int id, int userId) {
        List<Exam> exams = em.createNamedQuery(Exam.GET_NEXT, Exam.class)
                             .setParameter("id", id)
                             .setParameter("userId", userId)
                             .setMaxResults(2)
                             .getResultList();
        return exams;
    }

    @Override
    public List<Exam> getPrevious(int id, int userId) {
        List<Exam> exams = em.createNamedQuery(Exam.GET_PREVIOUS, Exam.class)
                             .setParameter("id", id)
                             .setParameter("userId", userId)
                             .setMaxResults(2)
                             .getResultList();
        return exams;
    }

    @Override
    public List<Exam> getFirst(int userId) {
        List<Exam> exams = em.createNamedQuery(Exam.GET_FIRST, Exam.class)
                             .setParameter("userId", userId)
                             .setMaxResults(2)
                             .getResultList();
        return exams;
    }

    @Override
    public List<Exam> getLast(int userId) {
        List<Exam> exams = em.createNamedQuery(Exam.GET_LAST, Exam.class)
                             .setParameter("userId", userId)
                             .setMaxResults(2)
                             .getResultList();
        return exams;
    }
}
