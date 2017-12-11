package kz.gala.testing.to;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import kz.gala.testing.model.Theme;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

//смотрим на все поля, не смотрим на геттеры, на is- геттеры, на сеттеры
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class ThemeTo {
    private final Integer id;
    private final String name;

    public ThemeTo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public ThemeTo(Theme t) {
        this.id = t.getId();
        this.name = t.getName();

    }
}
