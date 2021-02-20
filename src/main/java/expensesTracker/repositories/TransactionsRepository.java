
package expensesTracker.repositories;

import expensesTracker.models.Transaction;
import expensesTracker.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import expensesTracker.models.Expense;

import java.util.List;

@Repository
public interface TransactionsRepository extends CrudRepository<Transaction, Integer>{


    public List<Transaction> getTransactionByUser(User user);
}
