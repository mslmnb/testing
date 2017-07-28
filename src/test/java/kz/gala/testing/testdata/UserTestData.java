package kz.gala.testing.testdata;

import kz.gala.testing.matcher.ModelMatcher;
import kz.gala.testing.model.Role;
import kz.gala.testing.model.User;
import kz.gala.testing.util.PasswordUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Objects;

import static kz.gala.testing.model.BaseEntity.START_SEQ;
import static kz.gala.testing.testdata.ThemeTestData.THEME1;


public class UserTestData {

    private static final Logger LOG = LoggerFactory.getLogger(UserTestData.class);

    public static final int USER_ID = START_SEQ + 10;
    public static final int ADMIN_ID = START_SEQ + 11;

    public static final User USER = new User(USER_ID, THEME1, "Сергеев И.И.", "инженер 1 кат", "секретный отдел", "user", "$2a$10$m3o0NecLqcbt.7JHe2/gu.V4ae6Syn8k0iKxNJWwO3zsJ.IcA/1rq", false, Role.ROLE_USER);
    public static final User ADMIN = new User(ADMIN_ID, THEME1, "Антонов И.И.", "инженер 2 кат", "админ отдел", "admin", "$2a$10$gg2voU/Spf7OXjya63W36O6GhYIqgEkRZaTYhMgZlhKsOMJ7zMrsO", false, Role.ROLE_ADMIN);


    public static final ModelMatcher<User> MATCHER = ModelMatcher.of(User.class,
            ((expected, actual) -> expected==actual ||
                    (
                            comparePassword(expected.getPassword(), actual.getPassword())&&
                            Objects.equals(expected.getId(), actual.getId())
                            && Objects.equals(expected.getTheme(), actual.getTheme())
                            && Objects.equals(expected.getPosition(), actual.getPosition())
                            && Objects.equals(expected.getDepartment(), actual.getDepartment())
                            && Objects.equals(expected.getLogin(), actual.getLogin())
                            && Objects.equals(expected.isComplete(), actual.isComplete())
                    )
            ));

    private static boolean comparePassword(String rawOrEncodedPassword, String password) {
        if (PasswordUtil.isEncoded(rawOrEncodedPassword)) {
            return rawOrEncodedPassword.equals(password);
        } else if (!PasswordUtil.isMatch(rawOrEncodedPassword, password)) {
            LOG.error("Password" + password + " doesn't match encoded " + password);
            return false;
        }
        return true;
    }

}
