package com.sport.sports_reservations.results.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.sport.sports_reservations.auth.model.User;
import com.sport.sports_reservations.booking.model.Facility;
import com.sport.sports_reservations.booking.model.Reservation;
import com.sport.sports_reservations.booking.model.Sport;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;


//---------- MATCH RESULTS ----------
@Getter
@Setter

public class MatchResult {

    private Integer id;


    private Facility facility;


    private User user;

    @NotNull(message = "La fecha es obligatoria")
    @FutureOrPresent(message = "La fecha no puede ser en el pasado")
    private LocalDate date;

    @NotNull(message = "La hora es obligatoria")
    private LocalTime hour;

    @NotBlank(message = "El estado no puede estar vacío")
    @Pattern(regexp = "^(PENDING|CONFIRMED|CANCELLED)$",
            message = "El estado debe ser PENDING, CONFIRMED o CANCELLED")
    private String status;


    private Reservation reservation;
    

    private Sport sport;

    
    
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getHour() {
		return hour;
	}

	public void setHour(LocalTime hour) {
		this.hour = hour;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}
    
    
    
    
    
    

}
