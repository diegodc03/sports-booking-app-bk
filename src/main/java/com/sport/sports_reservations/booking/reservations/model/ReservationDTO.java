package com.sport.sports_reservations.booking.reservations.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sport.sports_reservations.auth.model.UserDTO;
import com.sport.sports_reservations.booking.facility.model.FacilityDTO;
import com.sport.sports_reservations.results.model.MatchResultDTO;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

//---------- RESERVATIONS ----------
@Getter
@Setter
public class ReservationDTO {

    private Integer id;


    private FacilityDTO facility;

    private UserDTO user;

    @NotNull(message = "La fecha es obligatoria")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "La fecha no puede ser en el pasado")
    private LocalDate  date;

    @NotNull(message = "La hora es obligatoria")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime  hour;

    @NotBlank(message = "El estado no puede estar vacío")
    @Pattern(regexp = "^(PENDING|CONFIRMED|CANCELLED)$",
            message = "El estado debe ser PENDING, CONFIRMED o CANCELLED")
    private String status;

    private List<MatchResultDTO> matchResults;
      
}

