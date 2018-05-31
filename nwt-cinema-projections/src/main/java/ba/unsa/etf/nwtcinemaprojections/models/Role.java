package ba.unsa.etf.nwtcinemaprojections.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Role extends AbstractModel {

	@NotNull
	private String roleTitle;

	@NotNull
	private String description;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role", targetEntity = UserAccount.class,
			cascade = CascadeType.ALL, orphanRemoval = true)
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
