package kz.gala.testing.repository.datajpa;

import kz.gala.testing.model.Exam;
import kz.gala.testing.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


//@Repository включить только после описания профилей для datajpa и jpa
public class DataJpaExamRepositoryImpl { //implements ExamRepository {

//    @Autowired
//    private CrudExamRepository crudRepository;
//
//
//    public List<Exam> getNextFrom(Integer id) {
//        return crudRepository.findByQuestionIdMoreThanEqualOrderByQuestionId(id);
//    }
//
//    public List<Exam> getPreviousFrom(Integer id) {
//        return crudRepository.findByQuestionIdLessThanEqualOrderByQuestionIdDesc(id);
//    }
//
//    public List<Exam> getFirst(Integer id) {
//        return crudRepository.findByQuestionIdLessThanEqualOrderByQuestionIdDesc(id);
//    }
//
//    @Override
//    public List<Exam> getNextFrom(int id, int userId) {
//        return null;
//    }
//
//    @Override
//    public List<Exam> getPreviousFrom(int id, int userId) {
//        return null;
//    }
//
//    @Override
//    public List<Exam> getFirst(int userId) {
//        return null;
//    }
//
//    @Override
//    public List<Exam> getLast(int userId) {
//        return null;
//    }
//
//    @Override
//    public Exam update(Exam exam, int userAnswerId, int userId) {
//        return null;
//    }
//
//    @Override
//    public Exam get(int questionId, int userId) {
//        return null;
//    }
//
//    @Override
//    public List<Exam> getAll(int userId) {
//        return null;
//    }
}



