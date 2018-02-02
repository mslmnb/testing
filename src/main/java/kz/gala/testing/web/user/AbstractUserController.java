package kz.gala.testing.web.user;

import kz.gala.testing.model.Role;
import kz.gala.testing.model.User;
import kz.gala.testing.service.ExamService;
import kz.gala.testing.service.UserService;
import kz.gala.testing.to.UserTo;
import kz.gala.testing.to.UserFullTo;
import kz.gala.testing.util.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

import static kz.gala.testing.util.UserUtil.asFullTo;
import static kz.gala.testing.util.UserUtil.createFromFullTo;
import static kz.gala.testing.util.ValidationUtil.checkIdConsistent;
import static kz.gala.testing.util.ValidationUtil.checkNew;

public abstract class AbstractUserController {
    private final Logger LOG = LoggerFactory.getLogger(AbstractUserController.class);

    private final UserService service;
    private final ExamService examService;

    public AbstractUserController(UserService service, ExamService examService) {
        this.service = service;
        this.examService = examService;
    }

    public UserService getService() {
        return service;
    }


    public UserFullTo getFullTo(int id) {
        LOG.info("get user{}", id);
        return UserUtil.asFullTo(service.get(id));
    }

    public User get(int id) {
        LOG.info("get user{}", id);
        return service.get(id);
    }

    public void update(UserTo userTo, int userId) {
        LOG.info("update user{} from userTo {}", userId, userTo);
        checkIdConsistent(userTo, userId);
        service.update(userTo);
    }

    public void update(UserFullTo userFullTo, int userId) {
        LOG.info("update user {}  from userFullTo {}", userId, userFullTo);
        checkIdConsistent(userFullTo, userId);
        service.update(userFullTo);
    }

    public void updateWithNoComplete(UserTo userTo, int userId) {
        LOG.info("update user with no complete {}", userId);
        service.updateWithNoComplete(userTo);
    }


    public void examStart(int id) {
        examService.delete(id);
        examService.insert(id);
    }

    public void delete(int id) {
        LOG.info("delete user {}", id);
        service.delete(id);
    }

    public List<UserFullTo> getAll(int themeId) {
        LOG.info("get all users for theme {}", themeId);
        return service.getAll(themeId).stream().map(u-> asFullTo(u)).collect(Collectors.toList());
    }

    public User create(UserFullTo userFullTo, int themeId, Role role){
        LOG.info("create user from userFullTo {} for a theme {}", userFullTo, themeId);
        checkNew(userFullTo);
        User newUser = createFromFullTo(userFullTo, themeId, role);
        return service.save(newUser);
    }




}
