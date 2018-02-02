package kz.gala.testing.repository;

import kz.gala.testing.model.User;

import java.util.List;

public interface UserRepository {
    // null if not found
    User get(int id);
    User save(User user);

    User getByLogin(String login);

    List<User> getAll(int themeId);

    boolean delete(int id);
}
