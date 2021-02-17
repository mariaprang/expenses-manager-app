
package expensesTracker.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import expensesTracker.models.Expense;

@Repository
public interface ExpensesRepository extends CrudRepository<Expense, Integer>{

}
