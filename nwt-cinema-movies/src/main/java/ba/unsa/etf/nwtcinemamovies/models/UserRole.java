package ba.unsa.etf.nwtcinemamovies.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserRole extends AbstractModel {

	@JoinColumn(name = "role_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Integer roleId;

	@Column(name = "user_id")
	private Integer userId;

	@Id
	@GeneratedValue
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
