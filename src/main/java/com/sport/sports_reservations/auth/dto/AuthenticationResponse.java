package com.sport.sports_reservations.auth.dto;


import com.sport.sports_reservations.auth.model.UserDTO;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AuthenticationResponse {
    private String token;
    private UserDTO user;

	public AuthenticationResponse(String token, UserDTO user) {
		super();
		this.token = token;
		this.user = user;
	}

    public String getToken() {
    			return token;
    }
    
    public void setToken(String token) {
    			this.token = token;
    }
    
    public UserDTO getUser() {
				return user;
	}
    
    public void setUser(UserDTO user) {
    			this.user = user;
    }
    
    public AuthenticationResponse() {
    			super();
    }


}
