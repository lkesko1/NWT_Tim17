package ba.unsa.etf.nwtcinemaauth.models;

import javax.persistence.Entity;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
public class User extends AbstractModel {

	@NotNull
	@Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	private String email;

	@NotNull
	@Size(min=4, max=8)
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{4,8}$") //between 4 and 8 characters, at least one letter and one number:
	private String password;

	@NotNull
	@Size(min=3)
	private String userName;

	@NotNull
	@Size(min=3)
	@Pattern(regexp = "^[A-Z]([A-Za-z]{2,})$")
	private String firstName;

	@NotNull
	@Size(min=3)
	@Pattern(regexp = "^[A-Z]([A-Za-z]{2,})$")
	private String lastName;

	@NotNull
	@Past
	private Date birthday;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public User() {
	}

	public User(String email, String password, String userName, String firstName, String lastName, Date birthday) {
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
	}

	public String toString() {
		return "User(Name: " + this.getFirstName() + " " + this.getLastName() + ")" + " " + this.getUserName();
	}
}
