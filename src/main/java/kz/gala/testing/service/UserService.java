package kz.gala.testing.service;

import kz.gala.testing.model.User;
import kz.gala.testing.to.ExamReport;
import kz.gala.testing.to.UserTo;
import kz.gala.testing.util.exception.NotFoundException;

public interface UserService {
    User get(int id) throws NotFoundException;
    User update(UserTo userTo, int userId)throws NotFoundException;
}
