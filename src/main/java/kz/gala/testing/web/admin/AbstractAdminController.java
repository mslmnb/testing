package kz.gala.testing.web.admin;

import kz.gala.testing.Profiles;
import kz.gala.testing.model.BaseEntity;
import kz.gala.testing.model.Theme;
import kz.gala.testing.service.ThemeService;
import kz.gala.testing.util.exception.ApplicationException;
import kz.gala.testing.web.ExceptionInfoHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;

import java.util.List;

import static kz.gala.testing.util.ValidationUtil.checkIdConsistent;
import static kz.gala.testing.util.ValidationUtil.checkNew;

public class AbstractAdminController {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractAdminController.class);

    public static final String EXCEPTION_MODIFICATION_RESTRICTION = "exception.theme.modificationRestriction";

    private final ThemeService themeService;

    @Autowired
    private ExceptionInfoHandler exceptionInfoHandler;

    private boolean modificationRestriction;

    @Autowired
    public void setEnvironment(Environment environment) {
        modificationRestriction = environment.acceptsProfiles(Profiles.HEROKU);
    }

    public AbstractAdminController(ThemeService themeService) {
        this.themeService = themeService;
    }

    public Theme get(int id) {
        LOG.info("get theme{}", id);
        return themeService.get(id);
    }

    public void delete(int id) {
        LOG.info("delete theme {}", id);
        checkModificationAllowed(id);
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


    public void checkModificationAllowed(int id) {
        if(modificationRestriction && id== BaseEntity.START_SEQ) {
            throw new ApplicationException(EXCEPTION_MODIFICATION_RESTRICTION, HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
        }
    }
}