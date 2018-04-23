package ba.unsa.etf.nwtcinemareservations.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class UserRole extends AbstractModel {

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Role.class)
	@NotNull
	private Role role;

	@NotNull
	@Min(1)
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

	public UserRole() {
	}

	public UserRole(Role role, Long userId) {
		this.role = role;
		this.userId = userId;
	}
}