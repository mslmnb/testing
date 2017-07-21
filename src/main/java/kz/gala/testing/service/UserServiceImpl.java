package kz.gala.testing.service;

import kz.gala.testing.model.User;
import kz.gala.testing.repository.UserRepository;
import kz.gala.testing.to.UserTo;
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

    @Override
    public User update(UserTo userTo, int userId) throws NotFoundException {
        if (userTo.getId()!=userId) {
            // завести класс исключения AccessException
            throw new NotFoundException("Can't update entity with id="+ userId);
        }
        User user = get(userId);
        user.setDepartment(userTo.getDepartment());
        user.setPosition(userTo.getPosition());
        user.setName(userTo.getName());
        return checkNotFoundWithId(repository.save(user), userId);
    }
}
