
package expensesTracker.repositories;

import expensesTracker.models.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import expensesTracker.models.Expense;

@Repository
public interface TransactionsRepository extends CrudRepository<Transaction, Integer>{

}
