package kz.gala.testing.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name="themes")
public class Theme extends BaseEntity {

    @Column(name = "name", nullable=false)
    @NotBlank
    private String name;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy="theme")
//    private List<Question> questions;
//
//    @OneToMany(fetch =FetchType.LAZY, mappedBy = "theme")
//    private List<User> users;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Theme that = (Theme) o;

        if (this.getId()!=null ? !this.getId().equals(that.getId()) : that.getId()!=null ) {
            return false;
        }
        return name != null ? name.equals(that.name) : that.name == null;
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

    @Override
    public String toString() {
        return "Theme{" +
                "name='" + name + '\'' +
                '}';
    }
}
