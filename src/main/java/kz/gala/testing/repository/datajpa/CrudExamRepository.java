package kz.gala.testing.repository.datajpa;

import kz.gala.testing.model.Exam;
import org.hibernate.dialect.pagination.LimitHandler;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudExamRepository extends JpaRepository<Exam,Integer>{
//    @Modifying
//    @Query("SELECT FROM Exam e ORDER BY e.questionId LIMIT 2 WHERE e.questionId>=:id")
//    int getNext(@Param("id") int id);
//
//    @Modifying
//    @Query("SELECT FROM Exam e ORDER BY e.questionId DESC LIMIT 2 WHERE e.questionId<=:id")
//    int getPrevious(@Param("id") int id);
//
//
//    List<Exam> findByQuestionIdLessThanEqualOrderByQuestionIdDesc(int id);
//
//    List<Exam> findByQuestionIdMoreThanEqualOrderByQuestionId(int id);

}
