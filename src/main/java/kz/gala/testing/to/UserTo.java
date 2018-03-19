package kz.gala.testing.to;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.gala.testing.model.BaseEntity;
import kz.gala.testing.model.Theme;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class UserTo extends BaseEntity {

    @NotBlank
    @SafeHtml
    private String name;
    @NotBlank
    @SafeHtml
    private String position;
    @NotBlank
    @SafeHtml
    private String department;

    private Theme theme;

    public UserTo() {
    }

    public UserTo(Integer id, String name, String position, String department, Theme theme) {
        super(id);
        this.name = name;
        this.position = position;
        this.department = department;
        this.theme = theme;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "UserTo{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
