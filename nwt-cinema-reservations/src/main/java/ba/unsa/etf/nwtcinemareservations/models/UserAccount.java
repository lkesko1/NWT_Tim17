package ba.unsa.etf.nwtcinemareservations.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class UserAccount extends AbstractModel {

	@ManyToOne(targetEntity = Role.class)
	private Role role;

	@NotNull
	@Column(unique = true)
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserAccount() {
	}

	public UserAccount(Role role, String username) {
		this.role = role;
		this.username = username;
	}
}