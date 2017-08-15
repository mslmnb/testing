package kz.gala.testing.web.admin;

import kz.gala.testing.model.Theme;
import kz.gala.testing.service.ThemeService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="ajax/admin/themes")
public class AdminAjaxController extends AbstractAdminController{

    public AdminAjaxController(ThemeService themeService) {
        super(themeService);
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Theme> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Theme get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @Override
    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @PostMapping
    public void updateOrCreate(@Valid Theme theme) {
        if (theme.isNew()) {
            super.create(theme);
        } else {
            super.update(theme, theme.getId());
        }
    }
}
