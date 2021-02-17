package expensesTracker.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "expenses")
public class Expense extends BaseEntity {

    private String title;
    private ExpenseCategory category;
    private LocalDate dateOfEntry;
    private double amountOfExpense;

    public Expense() {
    }

    public Expense(String title, ExpenseCategory category,
                   LocalDate dateOfEntry, double amountOfExpense) {
        this.title = title;
        this.category = category;
        this.dateOfEntry = dateOfEntry;
        this.amountOfExpense = amountOfExpense;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ExpenseCategory getCategory() {
        return category;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }

    public LocalDate getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(LocalDate dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public double getAmountOfExpense() {
        return amountOfExpense;
    }

    public void setAmountOfExpense(double amountOfExpense) {
        this.amountOfExpense = amountOfExpense;
    }


}
