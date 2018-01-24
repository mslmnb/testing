package kz.gala.testing.web.admin;

import kz.gala.testing.model.Question;
import kz.gala.testing.model.Theme;
import kz.gala.testing.service.ThemeService;
import kz.gala.testing.to.ThemeTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
    public List<ThemeTo> getAll() {
        return super.getAll();
    }

    @Override
    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ThemeTo get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @Override
    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @PostMapping
    public ResponseEntity<String> updateOrCreate(@Valid Theme theme, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            result.getFieldErrors()
                    .forEach(fe -> sb.append(fe.getField())
                                        .append(" ")
                                        .append(fe.getDefaultMessage())
                                        .append("<br>")
                    );
            return new ResponseEntity<>(sb.toString(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if (theme.isNew()) {
            super.create(theme);
        } else {
            super.update(theme, theme.getId());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
