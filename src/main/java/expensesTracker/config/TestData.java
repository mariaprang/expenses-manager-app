package expensesTracker.config;

import expensesTracker.models.*;
import expensesTracker.services.TransactionService;
import expensesTracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class TestData {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Transaction [] fakeTransactions = { new Transaction("Monthly Salary", TransactionType.INCOME, LocalDate.now(),2500),
            new Expense("Went to movies", TransactionType.EXPENSE, LocalDate.now(), 70, ExpenseCategory.FUN),
            new Expense("Bought groceries", TransactionType.EXPENSE, LocalDate.now(), 70, ExpenseCategory.GROCERIES),
            new Expense("Work commute", TransactionType.EXPENSE, LocalDate.now(), 15, ExpenseCategory.TRANSPORT),
            new Expense("Bought Spike a new toy", TransactionType.EXPENSE, LocalDate.now(), 20, ExpenseCategory.PETS),
            new Expense("COVID PCR Test", TransactionType.EXPENSE, LocalDate.now(), 180, ExpenseCategory.HEALTH),
            new Expense("Bought a new chair", TransactionType.EXPENSE, LocalDate.now(), 200, ExpenseCategory.HOME),
            new Expense("Got a book Sara recommended", TransactionType.EXPENSE, LocalDate.now(), 30, ExpenseCategory.EDUCATION),
            new Expense("Paid a rent", TransactionType.EXPENSE, LocalDate.now(), 499, ExpenseCategory.RENT),
            new Expense("Travelled to grandma", TransactionType.EXPENSE, LocalDate.now(), 500, ExpenseCategory.TRAVEL)
    };

    @PostConstruct
    public void init(){
        User user = new User("test@gmail.com", passwordEncoder.encode("test"));
        userService.saveUser(user);

        for(Transaction transaction : fakeTransactions){
            user.getExpenses().add(transaction);
            transaction.setUser(user);
            transactionService.saveTransaction(transaction);
        }

        User user2 = new User("mest@gmail.com", passwordEncoder.encode("test"));
        userService.saveUser(user2);

    }
}
