package kz.gala.testing.to;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import kz.gala.testing.model.BaseEntity;
import kz.gala.testing.model.Theme;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

public class ThemeTo extends BaseEntity {
    private final String name;

    public ThemeTo(Integer id, String name) {
        super(id);
        this.name = name;
    }

}
