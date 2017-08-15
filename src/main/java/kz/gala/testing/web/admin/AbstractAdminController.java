package kz.gala.testing.web.admin;

import kz.gala.testing.model.Theme;
import kz.gala.testing.service.ThemeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static kz.gala.testing.util.ValidationUtil.checkIdConsistent;
import static kz.gala.testing.util.ValidationUtil.checkNew;

public class AbstractAdminController {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractAdminController.class);

    private final ThemeService themeService;

    public AbstractAdminController(ThemeService themeService) {
        this.themeService = themeService;
    }

    public Theme get(int id) {
        LOG.info("get theme{}", id);
        return themeService.get(id);
    }

    public void delete(int id) {
        LOG.info("delete theme {}", id);
        themeService.delete(id);
    }

    public Theme create(Theme theme) {
        LOG.info("create {}", theme);
        checkNew(theme);
        return themeService.save(theme);
    }

    public void update(Theme theme, int themeId) {
        LOG.info("update {} with id={}", theme, themeId);
        checkIdConsistent(theme, themeId);
        themeService.update(theme);
    }

    public List<Theme> getAll() {
        LOG.info("get all themes");
        return themeService.getAll();

    }


}
