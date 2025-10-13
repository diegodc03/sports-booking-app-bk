package com.sport.sports_reservations.auth.dto;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AuthenticationResponse {
    private String token;

	public AuthenticationResponse(String token) {
		super();
		this.token = token;
	}

    public String getToken() {
    			return token;
    }
    
    public void setToken(String token) {
    			this.token = token;
    }
    
    public AuthenticationResponse() {
    			super();
    }


}
