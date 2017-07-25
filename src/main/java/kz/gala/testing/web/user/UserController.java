package kz.gala.testing.web.user;

import kz.gala.testing.AuthorizedUser;
import kz.gala.testing.model.User;
import kz.gala.testing.service.ExamService;
import kz.gala.testing.service.UserService;
import kz.gala.testing.to.UserTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        UserTo userTo = new UserTo(user);
        model.addAttribute("userTo", userTo);
        return "profile";
    }

    @PostMapping(value = "/profile")
    public String updateProfile(@Param("id") Integer id,
            @Param("name") String name,
            @Param("position") String position,
            @Param("department") String department) {
        UserTo userTo = new UserTo(id, name, position, department);
        super.updateWithNoComplete(userTo, AuthorizedUser.id());
        super.examStart( AuthorizedUser.id());
        return "redirect:/exam";

    }
}