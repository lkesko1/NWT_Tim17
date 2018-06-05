package ba.unsa.etf.nwtcinemareservations.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserAccount extends AbstractModel {

	@ManyToOne(targetEntity = Role.class)
	private Role role;

	@NotNull
	@Column(unique = true)
	private String username;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userAccount", targetEntity = Reservation.class,
			cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Reservation> reservations = new ArrayList<>();

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

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
}