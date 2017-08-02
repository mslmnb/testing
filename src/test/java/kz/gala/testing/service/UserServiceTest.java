package kz.gala.testing.service;

import kz.gala.testing.model.User;
import kz.gala.testing.to.UserTo;
import kz.gala.testing.util.UserUtil;
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
    public void testGetByLogin() {
        MATCHER.assertEquals(USER, service.getByLogin("user"));
    }

    @Test
    public void testUpdate() throws Exception {
        String updatePosition = "обновление должности";
        String updateDepartment = "обновление подразделения";
        String updateName = "обновление имени";
        UserTo userTo = UserUtil.asTo(USER);
        userTo.setPosition(updatePosition);
        userTo.setDepartment(updateDepartment);
        userTo.setName(updateName);
        service.update(userTo);

        User updatedUser = new User(USER_ID, USER.getTheme(), updateName, updatePosition, updateDepartment,
                USER.getLogin(), USER.getPassword(), USER.isComplete(), USER.getRole());
        MATCHER.assertEquals(updatedUser, service.get(USER_ID));
    }

    @Test
    public void testUpdateWithNoComplete() throws Exception {
        User updatedUser = new User(USER_ID, USER.getTheme(), USER.getName(), USER.getPosition(), USER.getDepartment(),
                USER.getLogin(), USER.getPassword(), true, USER.getRole());

        service.save(updatedUser);

        String updatePosition = "обновление должности";
        String updateDepartment = "обновление подразделения";
        String updateName = "обновление имени";
        UserTo userTo = UserUtil.asTo(USER);
        userTo.setPosition(updatePosition);
        userTo.setDepartment(updateDepartment);
        userTo.setName(updateName);
        service.updateWithNoComplete(userTo);

        updatedUser = new User(USER_ID, USER.getTheme(), updateName, updatePosition, updateDepartment,
                USER.getLogin(), USER.getPassword(), false, USER.getRole());
        MATCHER.assertEquals(updatedUser, service.get(USER_ID));

    }

    @Test
    public void testSave() {
        String updatePosition = "обновление должности";
        String updateDepartment = "обновление подразделения";
        String updateName = "обновление имени";
        User updatedUser = new User(USER_ID, USER.getTheme(), updateName, updatePosition, updateDepartment,
                USER.getLogin(), USER.getPassword(), true, USER.getRole());

        MATCHER.assertEquals(updatedUser,service.save(updatedUser));

    }

}
