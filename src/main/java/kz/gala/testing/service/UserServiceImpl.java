package kz.gala.testing.service;

import kz.gala.testing.AuthorizedUser;
import kz.gala.testing.model.User;
import kz.gala.testing.repository.UserRepository;
import kz.gala.testing.to.UserFullTo;
import kz.gala.testing.to.UserTo;
import kz.gala.testing.util.UserUtil;
import kz.gala.testing.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

import static kz.gala.testing.util.UserUtil.prepareToSave;
import static kz.gala.testing.util.UserUtil.updateFromFullTo;
import static kz.gala.testing.util.UserUtil.updateFromTo;
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

    //@CacheEvict(value = "users", allEntries = true) есть в topjava проверить
    @Transactional                                  //  есть в topjava проверить
    @Override
    public void update(UserTo userTo) {
        User user = updateFromTo(userTo, get(userTo.getId()));
        repository.save(prepareToSave(user));
    }

    @Override
    public void update(UserFullTo userFullTo) {
        User user = updateFromFullTo(userFullTo, get(userFullTo.getId()));
        repository.save(prepareToSave(user));
    }

    @Override
    public void updateWithNoComplete(UserTo userTo) {
        User user = get(userTo.getId());
        updateFromTo(userTo, user);
        user.setComplete(false);
        save(user);
    }

    @Override
    public User save(User user) {
        return repository.save(UserUtil.prepareToSave(user));
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

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public List<User> getAll(int themeId) {
        return repository.getAll(themeId);
    }
}
