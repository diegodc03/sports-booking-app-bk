package com.sport.sports_reservations.auth.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sport.sports_reservations.booking.reservations.model.GuestUserDTO;
import com.sport.sports_reservations.booking.reservations.model.ReservationDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;





@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserDTO implements UserDetails {
    
	private static final long serialVersionUID = 7016536859739722852L;


    private Long id;

    private String firstname;
    private String lastName;
    private String email;
    private String password;
    private String telephone;
    private LocalDateTime createdAt;
	private List<ReservationDTO> reservations;
	private List<GuestUserDTO> guestUsers;
	private List<Role> roles;
    
    
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
	@Override
	public String getUsername() {
		return this.email;
	}


}




