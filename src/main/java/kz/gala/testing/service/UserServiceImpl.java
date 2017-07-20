package kz.gala.testing.service;

import kz.gala.testing.model.User;
import kz.gala.testing.repository.UserRepository;
import kz.gala.testing.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static kz.gala.testing.util.ValidationUtil.checkNotFoundWithId;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User get(int userId) throws NotFoundException {
        return checkNotFoundWithId(repository.get(userId), userId);
    }
}
