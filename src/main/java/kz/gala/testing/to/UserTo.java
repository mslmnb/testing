package kz.gala.testing.to;

import kz.gala.testing.model.User;

public class UserTo {
    private final String themeName;
    private final String name;
    private final String position;
    private final String department;

    public UserTo(User user) {
        this.themeName = user.getTheme().getName();
        this.name = user.getName();
        this.position = user.getPosition();
        this.department = user.getDepartment();
    }

    public String getThemeName() {
        return themeName;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }
}
