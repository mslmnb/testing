package kz.gala.testing.web.user;

import kz.gala.testing.AuthorizedUser;
import kz.gala.testing.model.Role;
import kz.gala.testing.model.User;
import kz.gala.testing.service.ExamService;
import kz.gala.testing.service.UserService;
import kz.gala.testing.to.UserTo;
import kz.gala.testing.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController extends AbstractUserController {

    @Autowired
    public UserController(UserService service, ExamService examService) {
        super(service, examService);
    }

    @GetMapping(value = "/profile")
    public String getProfile(Model model) {
        User user = super.get(AuthorizedUser.id());
        if (Role.ROLE_ADMIN.equals(user.getRole())) {
            return "redirect:/admin/themes";
        }
        UserTo userTo = UserUtil.asTo(user);;
        model.addAttribute("userTo", userTo);
        return "profile";
    }

    @PostMapping(value = "/profile")
    public String updateProfile(@Valid UserTo userTo) {
        //UserTo userTo = new UserTo(id, name, position, department);
        super.updateWithNoComplete(userTo, AuthorizedUser.id());
        super.examStart( AuthorizedUser.id());
        return "redirect:/exam";

    }
}