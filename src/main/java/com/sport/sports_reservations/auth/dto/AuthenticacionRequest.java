package com.sport.sports_reservations.auth.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticacionRequest {
    private  String email;
    private String password;
    
    public AuthenticacionRequest() {
		super();
	}
    
	public AuthenticacionRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    
    
}
