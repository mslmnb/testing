package kz.gala.testing.repository.datajpa;

import kz.gala.testing.model.User;
import kz.gala.testing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class DataJpaUserRepositoryImpl implements UserRepository {

    @Autowired
    private CrudUserRepository crudRepository;

    @Override
    public User get(int id) {
        return crudRepository.findOne(id);
    }

    @Override
    public User save(User user) {
        return crudRepository.save(user);
    }

    @Override
    public User getByLogin(String login) {
        return crudRepository.findByLogin(login);
    }

    @Override
    public List<User> getAll(int themeId) {
        return crudRepository.getAll(themeId);
    }

    @Override
    public boolean delete(int id) {
        return crudRepository.delete(id)!=0;
    }
}
