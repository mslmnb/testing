package kz.gala.testing.service;

import com.sun.deploy.security.UserDeclinedException;
import kz.gala.testing.to.UserTo;
import kz.gala.testing.util.exception.NotFoundException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static kz.gala.testing.testdata.UserTestData.*;

public class UserServiceTest extends AbstractServiceTest {
    @Autowired
    private UserService service;

    @Test
    public void testGet() throws Exception {
        MATCHER.assertEquals(USER, service.get(USER_ID));
        MATCHER.assertEquals(ADMIN, service.get(ADMIN_ID));
    }

    @Test
    public void testGetNotFound() throws Exception {
        thrown.expect(NotFoundException.class);
        thrown.expectMessage("Not found entity with id="+(USER_ID-1));
        service.get(USER_ID-1);
    }

    @Test
    public void testUpdate() throws Exception {
        String updatePosition = "обновление должности";
        String updateDepartment = "обновление подразделения";
        String updateName = "обновление имени";
        UserTo userTo = new UserTo(USER);
        userTo.setPosition(updatePosition);
        userTo.setDepartment(updateDepartment);
        userTo.setName(updateName);
        service.update(userTo, USER_ID);
        USER.setPosition(updatePosition);
        USER.setName(updateName);
        USER.setDepartment(updateDepartment);
        MATCHER.assertEquals(USER, service.get(USER_ID));
    }

    @Test
    public void testUpdateNotFound() throws Exception {
        UserTo userTo = new UserTo(USER);
        thrown.expect(NotFoundException.class);
        thrown.expectMessage("Can't update entity with id=" + (USER_ID+1));
        service.update(userTo, USER_ID+1);
    }

    @Test
    public void testUpdateWithNoComplete() throws Exception {
        USER.setComplete(true);
        service.save(USER);

        String updatePosition = "обновление должности";
        String updateDepartment = "обновление подразделения";
        String updateName = "обновление имени";
        UserTo userTo = new UserTo(USER);
        userTo.setPosition(updatePosition);
        userTo.setDepartment(updateDepartment);
        userTo.setName(updateName);
        service.updateWithNoComplete(userTo, USER_ID);

        USER.setPosition(updatePosition);
        USER.setName(updateName);
        USER.setDepartment(updateDepartment);
        USER.setComplete(false);

        MATCHER.assertEquals(USER, service.get(USER_ID));
    }

    @Test
    public void testUpdateWithNoCompleteNotFound() throws Exception {
        UserTo userTo = new UserTo(USER);
        thrown.expect(NotFoundException.class);
        thrown.expectMessage("Can't update entity with id=" + (USER_ID+1));
        service.updateWithNoComplete(userTo, USER_ID+1);

    }

    @Test
    public void testSave() {
        String updatePosition = "обновление должности";
        String updateDepartment = "обновление подразделения";
        String updateName = "обновление имени";
        USER.setPosition(updatePosition);
        USER.setName(updateName);
        USER.setDepartment(updateDepartment);
        USER.setComplete(true);
        MATCHER.assertEquals(USER,service.save(USER));

    }
}
