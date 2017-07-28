package kz.gala.testing.service;

import kz.gala.testing.model.User;
import kz.gala.testing.to.UserTo;
import kz.gala.testing.util.exception.NotFoundException;

public interface UserService {
    User get(int id) throws NotFoundException;
    void update(UserTo userTo);
    User save(User user);
    void updateWithNoComplete(UserTo userTo);

    User getByLogin(String login) throws NotFoundException;

}
