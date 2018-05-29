package ba.unsa.etf.nwtcinemamovies.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Role extends AbstractModel {

	@NotNull(message = "Role must have a title.")
	private String roleTitle;

	@NotNull
	private String description;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role", targetEntity = UserAccount.class,
			cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<UserAccount> userAccounts = new ArrayList<>();

	public String getRoleTitle() {
		return roleTitle;
	}

	public void setRoleTitle(String roleTitle) {
		this.roleTitle = roleTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<UserAccount> getUserAccounts() {
		return userAccounts;
	}

	public Role() {
	}

	public Role(String roleTitle, String description) {
		this.roleTitle = roleTitle;
		this.description = description;
	}
}
