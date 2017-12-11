package kz.gala.testing.service;

import kz.gala.testing.model.Theme;
import kz.gala.testing.to.ThemeTo;
import kz.gala.testing.util.exception.NotFoundException;

import java.util.List;

public interface ThemeService {

    Theme save(Theme t);

    void delete(int id) throws NotFoundException;

    Theme get(int id) throws NotFoundException;

    void update(Theme theme);

    List<Theme> getAll();

    void evictCache();

}
