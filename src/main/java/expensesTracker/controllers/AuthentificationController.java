package expensesTracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthentificationController {

    @RequestMapping("/authorize")
    public String authorizeUser(@RequestParam("username") String username, @RequestParam("password") String password){
        return "index";
    }

    @RequestMapping(value = {"/register"})
    public String registerNewUser(Model model) {

        return "redirect:/dashboard";
    }
}
