package kz.gala.testing.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/exam")
    public String exam() {
        return "exam";
    }

}