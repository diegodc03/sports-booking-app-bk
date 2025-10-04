package com.sport.sports_reservations.auth.model;

import java.time.LocalDateTime;
import java.util.List;

import com.sport.sports_reservations.booking.model.GuestUser;
import com.sport.sports_reservations.booking.model.Reservation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


//---------- USERS ----------
@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;

 private String username;
 private String name;
 private String surname;
 private String email;
 private String telephone;

 @ManyToOne
 @JoinColumn(name = "role_id")
 private Role role;

 @Column(name = "created_at")
 private LocalDateTime createdAt;

 @OneToMany(mappedBy = "user")
 private List<Reservation> reservations;

 @OneToMany(mappedBy = "user")
 private List<GuestUser> guestUsers;

 // Getters & Setters
}
