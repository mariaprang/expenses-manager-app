package expensesTracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import expensesTracker.models.Expense;
import expensesTracker.repositories.ExpensesRepository;

@Service
public class ExpensesService {
	
	@Autowired
	private ExpensesRepository expensesRepository;
	
	public void saveExpense(Expense expense) {
		expensesRepository.save(expense);
	}
	
	public List<Expense> getAllExpenses(){
		return (List<Expense>) expensesRepository.findAll();
	}

}
