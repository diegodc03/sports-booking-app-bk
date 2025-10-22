package com.sport.sports_reservations.results.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.sport.sports_reservations.auth.model.UserDTO;
import com.sport.sports_reservations.booking.model.FacilityDTO;
import com.sport.sports_reservations.booking.model.ReservationDTO;
import com.sport.sports_reservations.booking.model.SportDTO;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;


//---------- MATCH RESULTS ----------
@Getter
@Setter

public class MatchResultDTO {

    private Integer id;

    private FacilityDTO facility;

    private UserDTO userDTO;

    @NotNull(message = "La fecha es obligatoria")
    @FutureOrPresent(message = "La fecha no puede ser en el pasado")
    private LocalDate date;

    @NotNull(message = "La hora es obligatoria")
    private LocalTime hour;

    @NotBlank(message = "El estado no puede estar vacío")
    @Pattern(regexp = "^(PENDING|CONFIRMED|CANCELLED)$",
            message = "El estado debe ser PENDING, CONFIRMED o CANCELLED")
    private String status;

    private ReservationDTO reservation;
    
    private SportDTO sport;

    
}
