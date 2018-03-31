package ba.unsa.etf.nwtcinemamovies.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class UserRole extends AbstractModel {

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Role.class)
	@NotNull
	private Role role;

	@NotNull
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserRole(Role role, Long userId) {
		this.role = role;
		this.userId = userId;
	}

	public UserRole() {
	}
}
