package kz.gala.testing.repository;

import kz.gala.testing.model.User;

/**
 * Created by Mussulmanbekova_GE on 12.07.2017.
 */
public interface UserRepository {
    // null if not found
    User get(int id);
}
