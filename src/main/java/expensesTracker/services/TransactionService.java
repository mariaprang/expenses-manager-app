package expensesTracker.services;

import java.util.List;

import expensesTracker.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import expensesTracker.models.Expense;
import expensesTracker.repositories.TransactionsRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionsRepository expensesRepository;
	
	public void saveTransaction(Transaction transaction) {
		expensesRepository.save(transaction);
	}
	
	public List<Transaction> getAllExpenses(){
		return (List<Transaction>) expensesRepository.findAll();
	}

}
