package com.sport.sports_reservations.auth.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//---------- ROLES ----------
@Entity
@Table(name = "roles")
public class Role {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;

 @Column(name = "role_name")
 private String roleName;

 @OneToMany(mappedBy = "role")
 private List<User> users;

 // Getters & Setters
}
