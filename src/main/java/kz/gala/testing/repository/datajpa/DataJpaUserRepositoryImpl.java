package kz.gala.testing.repository.datajpa;

import kz.gala.testing.model.User;
import kz.gala.testing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Mussulmanbekova_GE on 12.07.2017.
 */
public class DataJpaUserRepositoryImpl implements UserRepository {
    @Autowired
    private CrudUserRepository crudUserRepository;

    @Override
    public User get(int id) {
        return crudUserRepository.findOne(id);
    }
}
