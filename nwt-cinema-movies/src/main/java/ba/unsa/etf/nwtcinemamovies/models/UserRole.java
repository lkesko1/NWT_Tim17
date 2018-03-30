package ba.unsa.etf.nwtcinemamovies.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class UserRole extends AbstractModel {

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Role.class)
	@NotNull
	private Role role;

	@NotNull
	@Min(1)
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
