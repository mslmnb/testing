package kz.gala.testing.util;

import kz.gala.testing.model.User;
import kz.gala.testing.to.UserTo;

/**
 * Created by Mussulmanbekova_GE on 28.07.2017.
 */
public class UserUtil {
    public static UserTo asTo(User user) {
        return new UserTo(user.getId(),user.getName(),user.getPosition(),user.getDepartment());
    }

    public static User updateFromTo(UserTo userTo, User user) {
        user.setDepartment(userTo.getDepartment());
        user.setPosition(userTo.getPosition());
        user.setName(userTo.getName());
        return user;
    }

    public static User prepareToSave(User user) {
        user.setPassword(PasswordUtil.encode(user.getPassword()));
        user.setLogin(user.getLogin().toLowerCase());
        return user;
    }



}
