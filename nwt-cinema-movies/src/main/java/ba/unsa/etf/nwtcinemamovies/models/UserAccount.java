package ba.unsa.etf.nwtcinemamovies.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserAccount extends AbstractModel {

	@ManyToOne(targetEntity = Role.class)
	private Role role;

	@OneToMany(mappedBy = "userAccount", targetEntity = MovieReview.class, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MovieReview> movieReviews = new ArrayList<>();

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
