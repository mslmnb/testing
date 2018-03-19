package kz.gala.testing.web.theme;

import kz.gala.testing.Profiles;
import kz.gala.testing.model.BaseEntity;
import kz.gala.testing.model.Theme;
import kz.gala.testing.service.ThemeService;
import kz.gala.testing.to.ThemeTo;
import kz.gala.testing.util.exception.ApplicationException;
import kz.gala.testing.web.ExceptionInfoHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;

import java.util.List;

import static kz.gala.testing.util.ThemeUtil.asTo;
import static kz.gala.testing.util.ThemeUtil.convertToListThemeTo;
import static kz.gala.testing.util.ValidationUtil.checkIdConsistent;
import static kz.gala.testing.util.ValidationUtil.checkNew;

public abstract class AbstractThemeController {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractThemeController.class);

    public static final String EXCEPTION_MODIFICATION_RESTRICTION = "exception.theme.modificationRestriction";

    private final ThemeService themeService;

    @Autowired
    private ExceptionInfoHandler exceptionInfoHandler;

    private boolean modificationRestriction;

    @Autowired
    public void setEnvironment(Environment environment) {
        modificationRestriction = environment.acceptsProfiles(Profiles.HEROKU);
    }

    public AbstractThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    public ThemeTo get(int id) {
        LOG.info("get theme {}", id);
        return asTo(themeService.get(id));
    }

    public void delete(int id) {
        LOG.info("deleteAllFor theme {}", id);
        checkModificationAllowed(id);
        themeService.delete(id);
    }

    public Theme create(Theme t) {
        LOG.info("create {}", t);
        checkNew(t);
        return themeService.save(t);
    }

    public void update(Theme t, int id) {
        LOG.info("update {} with id={}", t, id);
        checkIdConsistent(t, id);
        checkModificationAllowed(id);
        themeService.update(t);
    }

    public List<ThemeTo> getAll() {
        LOG.info("get all themes");
        return convertToListThemeTo(themeService.getAll());

    }


    private void checkModificationAllowed(int id) {
        if(modificationRestriction && id== BaseEntity.START_SEQ) {
            throw new ApplicationException(EXCEPTION_MODIFICATION_RESTRICTION, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
        }
    }
}
