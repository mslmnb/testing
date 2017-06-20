package kz.gala.testing.repository.datajpa;

import kz.gala.testing.model.Exam;
import kz.gala.testing.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Mussulmanbekova_GE on 15.06.2017.
 */

//@Repository
public class DataJpaExamRepositoryImpl implements ExamRepository {

    @Autowired
    private CrudExamRepository crudRepository;


    public List<Exam> getNext(Integer id) {
        return crudRepository.findByQuestionIdMoreThanEqualOrderByQuestionId(id);
    }

    public List<Exam> getPrevious(Integer id) {
        return crudRepository.findByQuestionIdLessThanEqualOrderByQuestionIdDesc(id);
    }

    public List<Exam> getFirst(Integer id) {
        return crudRepository.findByQuestionIdLessThanEqualOrderByQuestionIdDesc(id);
    }

    @Override
    public List<Exam> getNext(int id, int userId) {
        return null;
    }

    @Override
    public List<Exam> getPrevious(int id, int userId) {
        return null;
    }

    @Override
    public List<Exam> getFirst(int userId) {
        return null;
    }

    @Override
    public List<Exam> getLast(int userId) {
        return null;
    }
}
