package kz.gala.testing.to;

import kz.gala.testing.model.User;

public class UserTo {
    private Integer id;
    private String name;
    private String position;
    private String department;

    public UserTo() {
    }

    public UserTo(Integer id, String name, String position, String department) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.department = department;
    }

    public UserTo(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.position = user.getPosition();
        this.department = user.getDepartment();
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

    public Integer getId() {
        return id;
    }
}
