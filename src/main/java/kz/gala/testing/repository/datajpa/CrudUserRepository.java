package kz.gala.testing.repository.datajpa;

import kz.gala.testing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudUserRepository extends JpaRepository<User, Integer>{

    @Transactional
    @Modifying
    @SuppressWarnings("JpaQlInspection")
    @Query("DELETE FROM User u WHERE u.id=:id")
    int delete(@Param("id") int id);

    @Override
    User findOne(Integer id);

    @Transactional
    @Override
    User save(User user);

    User findByLogin(String login);

    @Modifying
    @SuppressWarnings("JpaQlInspection")
    @Query("SELECT u FROM User u WHERE u.theme.id=:themeId AND u.role='ROLE_USER'")
    List<User> getAll(@Param("themeId") int themeId);
}
