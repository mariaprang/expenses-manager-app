package expensesTracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

	
	@RequestMapping(value = {"/", "/index", "/home"})
	public String getHomePage() {
		return "index";
	}
	
	@RequestMapping("/expenses")
	public String getExpensesPage() {
		return "expenses";
	}
	
	@RequestMapping("/newExpense")
	public String createNewExpense() {
		return "new-expense";
	}
	
	@RequestMapping("/initialPage")
	public String loginPage() {
		return "registration";
	}
	
}
