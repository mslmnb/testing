package kz.gala.testing.service;

import kz.gala.testing.model.User;
import kz.gala.testing.to.UserReport;
import kz.gala.testing.util.exception.NotFoundException;

public interface UserService {
    User get(int id) throws NotFoundException;
    UserReport getUserReport(int userId);

}
