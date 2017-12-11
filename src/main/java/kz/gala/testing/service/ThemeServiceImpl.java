package kz.gala.testing.service;

import kz.gala.testing.model.Theme;
import kz.gala.testing.repository.ThemeRepository;
import kz.gala.testing.to.ThemeTo;
import kz.gala.testing.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static kz.gala.testing.util.ValidationUtil.checkNotFoundWithId;

@Service
public class ThemeServiceImpl implements ThemeService{
    private final ThemeRepository repository;

    @Autowired
    public ThemeServiceImpl(ThemeRepository repository) {
        this.repository = repository;
    }

    @CacheEvict(value="themes", allEntries = true)
    @Override
    public Theme save(Theme theme) {
        Assert.notNull(theme, "theme must not be null");
        return repository.save(theme);
    }

    @CacheEvict(value="themes", allEntries = true)
    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id),id);
    }

    @Override
    public Theme get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id),id);
    }

    @CacheEvict(value="themes", allEntries = true)
    @Override
    public void update(Theme theme) {
        Assert.notNull(theme, "theme must not be null");
        checkNotFoundWithId(repository.save(theme), theme.getId());
    }

    @Cacheable("themes")
    @Override
    public List<Theme> getAll() {
        return repository.getAll();
    }

    @CacheEvict(value = "themes", allEntries = true)
    @Override
    public void evictCache() {
        // only for evict cache
    }
}
