package kz.gala.testing.repository.datajpa;

import kz.gala.testing.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


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
