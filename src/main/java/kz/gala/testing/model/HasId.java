package kz.gala.testing.model;

/**
 * Created by Mussulmanbekova_GE on 14.06.2017.
 */
public interface HasId {
    Integer getId();

    void setId(Integer id);

    default boolean isNew() {
        return (getId()==null);
    }
}
