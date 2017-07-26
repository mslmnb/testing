package kz.gala.testing.service;

import kz.gala.testing.AuthorizedUser;
import kz.gala.testing.model.User;
import kz.gala.testing.repository.UserRepository;
import kz.gala.testing.to.UserTo;
import kz.gala.testing.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import static kz.gala.testing.util.ValidationUtil.checkNotFound;
import static kz.gala.testing.util.ValidationUtil.checkNotFoundWithId;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

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

    @Override
    public User updateWithNoComplete(UserTo userTo, int userId) throws NotFoundException {
        if (userTo.getId()!=userId) {
            // завести класс исключения AccessException
            throw new NotFoundException("Can't update entity with id="+ userId);
        }
        User user = get(userId);
        user.setDepartment(userTo.getDepartment());
        user.setPosition(userTo.getPosition());
        user.setName(userTo.getName());
        user.setComplete(false);
        return checkNotFoundWithId(save(user), userId);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public AuthorizedUser loadUserByUsername(String login) throws UsernameNotFoundException {
        User u = repository.getByLogin(login.toLowerCase());
        if (u == null) {
            throw new UsernameNotFoundException("User " + login + " is not found");
        }
        return new AuthorizedUser(u);
    }

    @Override
    public User getByLogin(String login) throws NotFoundException {
        Assert.notNull(login,"login must not be null");
        User u = repository.getByLogin(login);
        return checkNotFound(u,"login=" + login);
    }
}
