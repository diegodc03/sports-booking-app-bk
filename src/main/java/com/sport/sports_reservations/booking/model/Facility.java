package com.sport.sports_reservations.booking.model;

import java.util.List;


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


//---------- FACILITIES ----------
@Entity
@Getter
@Setter
@Table(name = "facilities")
public class Facility {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;

 @ManyToOne
 @JoinColumn(name = "city_id")
 private City city;

 @ManyToOne
 @JoinColumn(name = "sport_id")
 private Sport sport;

 private String name;
 private Integer capacity;

 @OneToMany(mappedBy = "facility")
 private List<Reservation> reservations;

 // Getters & Setters
}
