package kz.gala.testing.repository.datajpa;

import kz.gala.testing.model.Answer;
import kz.gala.testing.model.AnswerPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudAnswerRepository extends JpaRepository<Answer, AnswerPrimaryKey>{
    @Transactional
    @Modifying
    @SuppressWarnings("JpaQlInspection")
    @Query("DELETE FROM Answer a WHERE a.primaryKey.question.id = :questionId AND a.primaryKey.enumerator = :enumerator")
    int delete (@Param("questionId") int questionId, @Param("enumerator") int enumerator);

    @Override
    @Transactional
    Answer save(Answer a);

    @Override
    Answer findOne(AnswerPrimaryKey primaryKey);

    @Modifying
    @SuppressWarnings("JpaQlInspection")
    @Query("SELECT a FROM Answer a WHERE a.primaryKey.question.id = :questionId")
    List<Answer> getAll (@Param("questionId") int questionId);

}
