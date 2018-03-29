package ba.unsa.etf.nwtcinemamovies.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "role_user")
public class UserRole extends AbstractModel {

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Role.class)
	private Role role;

	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserRole(Role role, Integer userId) {
		this.role = role;
		this.userId = userId;
	}

	public UserRole() {
	}
}
