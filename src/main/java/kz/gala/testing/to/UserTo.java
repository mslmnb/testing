package kz.gala.testing.to;

import kz.gala.testing.model.User;

import java.io.Serializable;

public class UserTo implements Serializable {
    private static final long serialVersionUID = 1L;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "UserTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
