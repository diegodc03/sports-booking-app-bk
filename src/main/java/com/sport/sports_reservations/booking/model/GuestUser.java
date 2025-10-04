package com.sport.sports_reservations.booking.model;

import com.sport.sports_reservations.auth.model.User;
import com.sport.sports_reservations.booking.model.GuestUser;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


//---------- GUEST USERS ----------
@Entity
@Getter
@Setter
@Table(name = "guest_users")
public class GuestUser {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;

 private String username;
 private String surname;
 private String telephone;

 @ManyToOne
 @JoinColumn(name = "user_id")
 private User user;

 // Getters & Setters
}

