package kz.gala.testing.util;

import kz.gala.testing.model.Role;
import kz.gala.testing.model.Theme;
import kz.gala.testing.model.User;
import kz.gala.testing.to.UserTo;
import kz.gala.testing.to.UserFullTo;

/**
 * Created by Mussulmanbekova_GE on 28.07.2017.
 */
public class UserUtil {
    public static UserTo asTo(User user) {
        return new UserTo(user.getId(),user.getName(),user.getPosition(),user.getDepartment());
    }

    public static UserFullTo asFullTo(User user) {
        return new UserFullTo(user.getId(),user.getName(),user.getPosition(),user.getDepartment(),user.getLogin(),user.getPassword());
    }

    public static User updateFromTo(UserTo userTo, User user) {
        user.setDepartment(userTo.getDepartment());
        user.setPosition(userTo.getPosition());
        user.setName(userTo.getName());
        return user;
    }

    public static User updateFromFullTo(UserFullTo userFullTo, User user) {
        user.setName(userFullTo.getName());
        user.setPosition(userFullTo.getPosition());
        user.setDepartment(userFullTo.getDepartment());
        user.setLogin(userFullTo.getLogin());
        user.setPassword(userFullTo.getPassword());
        return user;
    }

    public static User prepareToSave(User user) {
        user.setPassword(PasswordUtil.encode(user.getPassword()));
        user.setLogin(user.getLogin().toLowerCase());
        return user;
    }

    public static  User createFromFullTo(UserFullTo userFullTo, int themeId, Role role) {
        return new User(userFullTo.getId(), new Theme(themeId), userFullTo.getName(),
                            userFullTo.getPosition(), userFullTo.getDepartment(),
                            userFullTo.getLogin(), userFullTo.getPassword(), false, role);
    }

}
