package kz.gala.testing.service;

import kz.gala.testing.util.exception.NotFoundException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static kz.gala.testing.testdata.UserTestData.*;

/**
 * Created by Mussulmanbekova_GE on 18.07.2017.
 */
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
    public void testGetUserReport() throws Exception {
        MATCHER_REPORT.assertEquals(USER_REPORT, service.getUserReport(USER_ID));
    }


}
