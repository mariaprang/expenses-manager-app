package expensesTracker.controllers;

import expensesTracker.models.User;
import expensesTracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebRedirectController {

    @Autowired
    private UserService userService;

    private User getAuthenticatedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userService.loadUserByUsername(username);
        return user;
    }

    @RequestMapping("/expenses")
    public String getExpensesPage(Model model) {
        model.addAttribute("user", getAuthenticatedUser());
        return "expenses";
    }

    @RequestMapping("/newExpense")
    public String createNewExpense() {
        return "new-expense";
    }

    @RequestMapping(value = {"/register"})
    public String loginPage() {
        return "registration";
    }


}
