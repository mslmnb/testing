package kz.gala.testing.web.user;

import kz.gala.testing.model.User;
import kz.gala.testing.service.UserService;
import kz.gala.testing.to.UserReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public UserReport getUserReport(int userId) {
        return service.getUserReport(userId);
    }

}