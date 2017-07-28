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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Theme that = (Theme) o;

        if (this.getId()!=null ? !this.getId().equals(that.getId()) : that.getId()!=null ) {
            return false;
        }
        boolean res = name != null ? name.equals(that.name) : that.name == null;
        return res;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Theme theme1 = new Theme(10, "ыаацкуа");
        Theme theme2 = new Theme(10, "ыаацкуа");
        System.out.println(theme1.equals(theme2));
    }
}
