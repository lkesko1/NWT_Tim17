package ba.unsa.etf.nwtcinemaprojections.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserRole {

	@JoinColumn(name = "role_id")
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Role.class)
	private Role roleId;

	@Column(name = "user_id")
	private Integer userId;


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}
}
