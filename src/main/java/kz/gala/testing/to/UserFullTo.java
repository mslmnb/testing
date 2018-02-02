package kz.gala.testing.to;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.gala.testing.model.BaseEntity;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotNull;

public class UserFullTo extends BaseEntity {

        @NotBlank
        private String name;
        @NotBlank
        private String position;
        @NotBlank
        private String department;
        @NotNull
        private String login;
        @NotNull
        @Length(min=5)
        @JsonIgnore
        private String password;

    public UserFullTo() {
    }

    public UserFullTo(Integer id, String name, String position, String department, String login, String password) {
        super(id);
        this.name = name;
        this.position = position;
        this.department = department;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserToFull{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
