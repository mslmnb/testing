package kz.gala.testing.repository.datajpa;

import kz.gala.testing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mussulmanbekova_GE on 12.07.2017.
 */

@Transactional(readOnly = true)

public interface CrudUserRepository extends JpaRepository<User, Integer>{
    @Override
    public User findOne(Integer id);
}
