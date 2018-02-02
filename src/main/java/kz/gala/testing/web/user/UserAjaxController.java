package kz.gala.testing.web.user;

import kz.gala.testing.model.Role;
import kz.gala.testing.model.User;
import kz.gala.testing.service.ExamService;
import kz.gala.testing.service.UserService;
import kz.gala.testing.to.UserFullTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="ajax/admin/themes/{themeId}/users")
public class UserAjaxController extends AbstractUserController{

    public UserAjaxController(UserService service, ExamService examService) {
        super(service, examService);
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserFullTo> getAll(@PathVariable("themeId") int themeId) {
        return super.getAll(themeId);
    }

    @Override
    @GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public UserFullTo getFullTo(@PathVariable("id") int id) {
        return super.getFullTo(id);
    }

    @Override
    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @PostMapping
    public ResponseEntity<String> updateOrCreate (@Valid UserFullTo userFullTo, BindingResult result, @PathVariable("themeId") int themeId) {
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
        if (userFullTo.isNew()) {
            super.create(userFullTo, themeId, Role.ROLE_USER);
        } else {
            super.update(userFullTo, userFullTo.getId());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
