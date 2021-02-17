package expensesTracker.models;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseEntity{
	
	private String username;
	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	private PhotoFile photoFile;
	
	private ArrayList<Expense> expenses;
	

	public User(String firstName, String lastName) {
		this.username = firstName;
		this.password = lastName;
		this.expenses = new ArrayList<>();
	}
	
	public User() {}

	public PhotoFile getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(PhotoFile photoFile) {
		this.photoFile = photoFile;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(ArrayList<Expense> expenses) {
		this.expenses = expenses;
	}

}
