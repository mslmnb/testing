package kz.gala.testing.web.exam;

import kz.gala.testing.model.User;
import kz.gala.testing.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Mussulmanbekova_GE on 12.07.2017.
 */
public abstract class AbstractUserController {
    private final Logger log = LoggerFactory.getLogger(AbstractUserController.class);

    private final UserService service;

    public UserService getService() {
        return service;
    }

    public AbstractUserController(UserService service) {
        this.service = service;
    }

    public User get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }
}
