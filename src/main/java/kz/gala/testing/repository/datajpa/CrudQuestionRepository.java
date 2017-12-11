package kz.gala.testing.repository.datajpa;


import kz.gala.testing.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudQuestionRepository extends JpaRepository<Question, Integer>{
    @Transactional
    @Modifying
    @SuppressWarnings("JpaQlInspection")
    @Query("DELETE FROM Question q WHERE q.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Question save(Question q);

    @Override
    Question findOne(Integer id);

    @Modifying
    @SuppressWarnings("JpaQlInspection")
    @Query("SELECT q FROM Question q WHERE q.theme.id=:themeId")
    List<Question> getAll (@Param("themeId") int themeId);
}
