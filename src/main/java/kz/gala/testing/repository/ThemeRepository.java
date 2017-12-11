package kz.gala.testing.repository;

import kz.gala.testing.model.Theme;
import kz.gala.testing.to.ThemeTo;

import java.util.List;

public interface ThemeRepository {

    Theme save(Theme t);

    // false if not found
    boolean delete(int id);

    // false if not found
    Theme get(int id);

    List<Theme> getAll();

}

