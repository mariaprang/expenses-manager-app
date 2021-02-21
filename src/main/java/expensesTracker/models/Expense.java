package expensesTracker.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Expense extends Transaction {

    private ExpenseCategory category;

    public Expense() {
    }

    public Expense(String title, TransactionType transactionType, LocalDate dateOfEntry, double transactionAmount, ExpenseCategory category) {
        super(title, transactionType, dateOfEntry, transactionAmount);
        this.category = category;
        this.isExpense = true;
    }

    public ExpenseCategory getCategory() {
        return category;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }
}
