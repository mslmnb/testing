package kz.gala.testing.repository;

import kz.gala.testing.model.User;

public interface UserRepository {
    // null if not found
    User get(int id);
    User save(User user);
}
