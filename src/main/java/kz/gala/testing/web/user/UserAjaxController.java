package kz.gala.testing.web.user;

import kz.gala.testing.AuthorizedUser;
import kz.gala.testing.service.UserService;
import kz.gala.testing.to.UserReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ajax/user")
public class UserAjaxController extends AbstractUserController {

    @Autowired
    public UserAjaxController(UserService service) {
        super(service);
    }

    @GetMapping(value="/report", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserReport getUserReport() {
        return super.getUserReport(AuthorizedUser.id());
    }


}
