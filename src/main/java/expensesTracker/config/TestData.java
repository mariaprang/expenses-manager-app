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

    @PostConstruct
    public void init(){
        User user = new User("test@gmail.com", passwordEncoder.encode("test"));
        //    public Transaction(String title, TransactionType transactionType, LocalDate dateOfEntry, double transactionAmount) {
        userService.saveUser(user);
        Transaction transaction1 = new Transaction("Monthly Salary", TransactionType.INCOME, LocalDate.now(),2500);
        user.getExpenses().add(transaction1);
        transaction1.setUser(user);
        transactionService.saveTransaction(transaction1);

        Transaction transaction2 = new Expense("Went to movies", TransactionType.EXPENSE, LocalDate.now(), 70, ExpenseCategory.FUN);
        user.getExpenses().add(transaction2);
        transaction2.setUser(user);
        transactionService.saveTransaction(transaction2);


        Transaction transaction3 = new Expense("Bought groceries", TransactionType.EXPENSE, LocalDate.now(), 70, ExpenseCategory.GROCERIES);
        user.getExpenses().add(transaction3);
        transaction3.setUser(user);
        transactionService.saveTransaction(transaction3);

        User user2 = new User("mest@gmail.com", passwordEncoder.encode("test"));
        userService.saveUser(user2);

    }
}
