package kz.gala.testing.repository.datajpa;

import kz.gala.testing.model.Theme;
import kz.gala.testing.repository.ThemeRepository;
import kz.gala.testing.to.ThemeTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DataJpaThemeRepositoryImpl implements ThemeRepository {

    private final CrudThemeRepository crudRepository;

    // конструктор по умолчанию нужен ???
    @Autowired
    public DataJpaThemeRepositoryImpl(CrudThemeRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public Theme save(Theme t) {
        return crudRepository.save(t);
    }

    @Override
    public boolean delete(int id) {
        return crudRepository.delete(id)!=0;
    }

    @Override
    public Theme get(int id) {
        return crudRepository.findOne(id);
    }

    @Override
    public List<Theme> getAll() {
        return crudRepository.findAll();
    }
}
