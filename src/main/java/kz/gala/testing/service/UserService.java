package kz.gala.testing.service;

import kz.gala.testing.model.User;
import kz.gala.testing.util.exception.NotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Mussulmanbekova_GE on 12.07.2017.
 */
@Service
public interface UserService {
    User get(int id) throws NotFoundException;
}
