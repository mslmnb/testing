package kz.gala.testing.repository.datajpa;

import kz.gala.testing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudUserRepository extends JpaRepository<User, Integer>{
    @Override
    User findOne(Integer id);

    @Transactional
    @Override
    User save(User user);

    User findByLogin(String login);
}
