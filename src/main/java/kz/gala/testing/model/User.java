package kz.gala.testing.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Mussulmanbekova_GE on 03.07.2017.
 */

@Entity
@Table(name="users")
public class User extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="theme_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Theme theme;

    @Column(name="name", nullable = false)
    @NotNull
    private String name;

    @Column(name="position", nullable = false)
    @NotNull
    private String position;

    @Column(name="department", nullable = false)
    @NotNull
    private String department;

    @Column(name="login", nullable = false)
    @NotNull
    private String login;

    @Column(name = "password", nullable = false)
    @NotNull
    @Length(min=5)
    private String password;

    public User(Integer id, Theme theme, String name, String position, String department, String login, String password) {
        super(id);
        this.theme = theme;
        this.name = name;
        this.position = position;
        this.department = department;
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "themeId=" + theme.getId() +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                ", login='" + login + '\'' +
//                ", roles=" + roles +
                '}';
    }
}