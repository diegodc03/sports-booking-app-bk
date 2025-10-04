package com.sport.sports_reservations.booking.model;

import java.util.List;

import com.sport.sports_reservations.results.model.MatchResult;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


//---------- SPORTS ----------
@Entity
@Getter
@Setter
@Table(name = "sports")
public class Sport {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;

 @Column(name = "sport_name")
 private String sportName;

 @Column(name = "max_players")
 private Integer maxPlayers;

 @OneToMany(mappedBy = "sport")
 private List<Facility> facilities;

 @OneToMany(mappedBy = "sport")
 private List<MatchResult> matchResults;

 // Getters & Setters
}