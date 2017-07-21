package kz.gala.testing.repository.datajpa;

import kz.gala.testing.model.User;
import kz.gala.testing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository

public class DataJpaUserRepositoryImpl implements UserRepository {

    @Autowired
    private CrudUserRepository crudUserRepository;

    @Override
    public User get(int id) {
        return crudUserRepository.findOne(id);
    }

    @Override
    public User save(User user) {
        return crudUserRepository.save(user);
    }
}
