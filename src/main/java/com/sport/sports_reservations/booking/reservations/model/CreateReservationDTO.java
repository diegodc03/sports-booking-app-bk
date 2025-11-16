package com.sport.sports_reservations.booking.reservations.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReservationDTO {
	
	private Long id;
	
	@NotNull(message = "El ID de la pista es obligatorio")
    private Integer facilityId;

	private Long userId;
	
    @NotNull(message = "La fecha es obligatoria")
    @FutureOrPresent(message = "La fecha no puede ser en el pasado")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @NotNull(message = "La hora es obligatoria")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime dateTime;

    private List<GuestUserDTO> players;
	
}
