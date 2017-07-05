package kz.gala.testing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="themes")
public class Theme extends BaseEntity {

    @Column(name = "name", nullable=false)
    @NotNull
    private String name;


    public Theme(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public Theme() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Theme{" +
                "name='" + name + '\'' +
                '}';
    }
}
