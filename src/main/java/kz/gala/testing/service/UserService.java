package kz.gala.testing.service;

import kz.gala.testing.model.User;
import kz.gala.testing.to.UserFullTo;
import kz.gala.testing.to.UserTo;
import kz.gala.testing.util.exception.NotFoundException;

import java.util.List;

public interface UserService {
    User get(int id) throws NotFoundException;
    void delete(int id) throws NotFoundException;
    void update(UserTo userTo);
    void update(UserFullTo userFullTo);
    User save(User user);
    void updateWithNoComplete(UserTo userTo);

    User getByLogin(String login) throws NotFoundException;
    List<User> getAll(int themeId);
}
