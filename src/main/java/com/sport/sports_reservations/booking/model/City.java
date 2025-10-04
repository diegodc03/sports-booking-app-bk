package com.sport.sports_reservations.booking.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


//---------- CITIES ----------
@Entity
@Table(name = "cities")
public class City {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;

 @Column(name = "city_name")
 private String cityName;

 @OneToMany(mappedBy = "city")
 private List<Facility> facilities;

 // Getters & Setters
}
