package kz.gala.testing.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

    @GetMapping(value = "/themes")
    public String themes(Model model) {
        return "themes";
    }
}
