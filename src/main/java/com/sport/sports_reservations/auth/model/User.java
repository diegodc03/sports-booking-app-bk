package com.sport.sports_reservations.auth.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sport.sports_reservations.booking.model.GuestUser;
import com.sport.sports_reservations.booking.model.Reservation;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;





@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails {
    
	private static final long serialVersionUID = 7016536859739722852L;


    private Integer id;

    private String firstname;
    private String lastName;
    private String email;
    private String password;
    private String telephone;
    private LocalDateTime createdAt;
	private List<Reservation> reservations;
	private List<GuestUser> guestUsers;
	private List<Role> roles;
    
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public List<GuestUser> getGuestUsers() {
		return guestUsers;
	}

	public void setGuestUsers(List<GuestUser> guestUsers) {
		this.guestUsers = guestUsers;
	}

    public List<Role> getRoles() {
		return roles;
	}

	public void setRole(List<Role> role) {
		this.roles = role;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (roles == null || roles.isEmpty()) return Collections.emptyList();

        return roles.stream()
                   .filter(r -> r.getRoleName() != null && !r.getRoleName().isBlank())
                   .map(r -> new SimpleGrantedAuthority(r.getRoleName()))
                   .toList();
    }


}




