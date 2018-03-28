package ba.unsa.etf.nwtcinemamovies.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Role extends AbstractModel {

	private String roleTitle;

	private String description;

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
}
