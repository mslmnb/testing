package kz.gala.testing;

import kz.gala.testing.model.Theme;
import kz.gala.testing.model.User;
import kz.gala.testing.to.UserTo;
import kz.gala.testing.util.UserUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collections;
import java.util.Objects;

public class AuthorizedUser extends org.springframework.security.core.userdetails.User {
    private static final long serialVersionUID = 1L;

    private final UserTo userTo;

    public AuthorizedUser(User user) {
        super(user.getLogin(), user.getPassword(), true, true, true, true, Collections.singleton(user.getRole()));
        userTo = UserUtil.asTo(user);
    }

    public static AuthorizedUser safeGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object principal = auth.getPrincipal();
        return (principal instanceof AuthorizedUser) ? (AuthorizedUser) principal : null;
    }

    public static AuthorizedUser get() {
        AuthorizedUser user = safeGet();
        Objects.requireNonNull(user, "No authorized user found");
        return user;
    }
    public static int id() {
        return get().userTo.getId();
    }

    public static int themeId() {
        return get().userTo.getTheme().getId();
    }

    public static Theme theme() {
        return get().userTo.getTheme();
    }

    public UserTo getUserTo() {
        return userTo;
    }

    @Override
    public String toString() {
        return userTo.toString();
    }

}
