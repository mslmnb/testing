package kz.gala.testing.model;

import org.hibernate.Hibernate;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@MappedSuperclass                              //отмечает класс, описанные свойства и методы которого будут применены
                                              // в классах-наследниках. супер класс не отображается на отдельную таблицу
@Access(AccessType.FIELD)
public class BaseEntity implements Persistable<Integer> {
    public static final int START_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    @Access(value = AccessType.PROPERTY)

    private Integer id;

    protected BaseEntity() {
    }

    protected BaseEntity(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return (getId() == null);
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) {
            return true;
        }
        if (obj==null||this.getClass().equals(Hibernate.getClass(obj))) {
            return false;
        }
        BaseEntity that = (BaseEntity) obj;

        return this.getId()!=null && this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId()==null ? 0 : getId() ;
    }

    @Override
    public String toString() {
        return String.format("Entity %s (%s)", getClass().getName(), getId());
    }

}
