package kz.gala.testing.web.user;

import kz.gala.testing.AuthorizedUser;
import kz.gala.testing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController extends AbstractUserController {

    @Autowired
    public UserController(UserService service) {
        super(service);
    }


}
