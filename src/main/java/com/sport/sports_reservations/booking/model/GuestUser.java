package com.sport.sports_reservations.booking.model;

import com.sport.sports_reservations.auth.model.User;
import com.sport.sports_reservations.booking.model.GuestUser;

import lombok.Getter;
import lombok.Setter;


//---------- GUEST USERS ----------

@Getter
@Setter

public class GuestUser {
	

	 private Integer id;
	
	 private String username;
	 private String surname;
	 private String telephone;
	
	 private User user;
	
	 public Integer getId() {
		return id;
	 }
	
	 public void setId(Integer id) {
		this.id = id;
	 }
	
	 public String getUsername() {
		return username;
	 }
	
	 public void setUsername(String username) {
		this.username = username;
	 }
	
	 public String getSurname() {
		return surname;
	 }
	
	 public void setSurname(String surname) {
		this.surname = surname;
	 }
	
	 public String getTelephone() {
		return telephone;
	 }
	
	 public void setTelephone(String telephone) {
		this.telephone = telephone;
	 }
	
	 public User getUser() {
		return user;
	 }
	
	 public void setUser(User user) {
		this.user = user;
	 }

}

