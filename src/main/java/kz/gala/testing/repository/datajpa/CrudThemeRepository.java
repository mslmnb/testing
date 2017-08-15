package kz.gala.testing.repository.datajpa;

import kz.gala.testing.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudThemeRepository extends JpaRepository<Theme, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Theme t WHERE t.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Theme save(Theme t);

    @Override
    Theme findOne(Integer id);

    @Override
    List<Theme> findAll();
}
