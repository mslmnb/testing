package kz.gala.testing.web.user;

import kz.gala.testing.model.User;
import kz.gala.testing.service.ExamService;
import kz.gala.testing.service.UserService;
import kz.gala.testing.to.UserTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractUserController {
    private final Logger log = LoggerFactory.getLogger(AbstractUserController.class);

    private final UserService service;
    private final ExamService examService;

    public AbstractUserController(UserService service, ExamService examService) {
        this.service = service;
        this.examService = examService;
    }

    public UserService getService() {
        return service;
    }


    public User get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    public User update(UserTo userTo, int userId) {
        log.info("update {}", userId);
        return service.update(userTo, userId);
    }

    public User updateWithNoComplete(UserTo userTo, int userId) {
        log.info("update with no complete {}", userId);
        return service.updateWithNoComplete(userTo, userId);

    }


    public void examStart(int id) {
        examService.delete(id);
        examService.insert(id);

    }

}
