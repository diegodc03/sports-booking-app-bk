package com.sport.sports_reservations.booking.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.sport.sports_reservations.auth.model.User;
import com.sport.sports_reservations.results.model.MatchResult;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

//---------- RESERVATIONS ----------
@Entity
@Getter
@Setter
@Table(name = "reservations")
public class Reservation {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false) // una reserva siempre pertenece a una instalación
    @JoinColumn(name = "facility_id", nullable = false)
    private Facility facility;

    @ManyToOne(optional = false) // una reserva siempre tiene un usuario
    @JoinColumn(name = "user_id", nullable = false)
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
    
    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MatchResult> matchResults;


}

