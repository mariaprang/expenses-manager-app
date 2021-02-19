package expensesTracker.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Transaction extends BaseEntity {

    private String title;
    private TransactionType transactionType;
    private LocalDate dateOfEntry;
    private double transactionAmount;

    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;

    public Transaction(String title, TransactionType transactionType, LocalDate dateOfEntry, double transactionAmount) {
        this.title = title;
        this.transactionType = transactionType;
        this.dateOfEntry = dateOfEntry;
        this.transactionAmount = transactionAmount;
    }

    public Transaction() {
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDate getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(LocalDate dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double amountOfExpense) {
        this.transactionAmount = amountOfExpense;
    }
}
