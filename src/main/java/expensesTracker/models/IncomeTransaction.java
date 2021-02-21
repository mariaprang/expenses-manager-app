package expensesTracker.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
public class IncomeTransaction extends Transaction{

    private String incomeSource;

    public IncomeTransaction(String title, TransactionType transactionType, LocalDate dateOfEntry, double transactionAmount, String incomeSource) {
        super(title, transactionType, dateOfEntry, transactionAmount);
        this.incomeSource = incomeSource;
        this.isExpense = false;
    }

    public IncomeTransaction() { }

    public String getIncomeSource() {
        return incomeSource;
    }

    public void setIncomeSource(String incomeSource) {
        this.incomeSource = incomeSource;
    }
}
