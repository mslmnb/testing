package kz.gala.testing.web;

import kz.gala.testing.AuthorizedUser;
import kz.gala.testing.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController  {

    @GetMapping("/")
    public String root() {
        return "index";
    }

//    @GetMapping("/profile")
//    public String profile() {
//        return "profile";
//    }

}