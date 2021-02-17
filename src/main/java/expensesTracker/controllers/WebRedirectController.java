package expensesTracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebRedirectController {

	@RequestMapping("/expenses")
	public String getExpensesPage() {
		return "expenses";
	}
	
	@RequestMapping("/newExpense")
	public String createNewExpense() {
		return "new-expense";
	}
	
	@RequestMapping(value = {"/", "/index"})
	public String loginPage() {
		return "registration";
	}

	@RequestMapping(value = {"/login"})
	public String showLogin(Model model) {
		return "login";
	}

	@RequestMapping(value = {"/dashboard"})
	public String getDashboard(Model model) {
		return "index";
	}
	
}
