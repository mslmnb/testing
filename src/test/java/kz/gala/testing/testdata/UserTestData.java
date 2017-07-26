package kz.gala.testing.testdata;

import kz.gala.testing.matcher.ModelMatcher;
import kz.gala.testing.model.Role;
import kz.gala.testing.model.User;

import static kz.gala.testing.model.BaseEntity.START_SEQ;
import static kz.gala.testing.testdata.ThemeTestData.THEME1;


public class UserTestData {
    public static final ModelMatcher<User> MATCHER = ModelMatcher.of(User.class);

    public static final int USER_ID = START_SEQ + 10;
    public static final int ADMIN_ID = START_SEQ + 11;

    public static final User USER = new User(USER_ID, THEME1, "Сергеев И.И.", "инженер 1 кат", "секретный отдел", "user", "UserPassword", false, Role.ROLE_USER);
    public static final User ADMIN = new User(ADMIN_ID, THEME1, "Антонов И.И.", "инженер 2 кат", "админ отдел", "admin", "AdminPassword", false, Role.ROLE_ADMIN);

    private UserTestData() {
    }
}
