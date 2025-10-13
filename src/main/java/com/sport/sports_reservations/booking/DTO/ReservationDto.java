package com.sport.sports_reservations.booking.DTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class ReservationDto {

    private Integer id;

    @NotNull(message = "El ID de la instalación es obligatorio")
    private Integer facilityId;

    @NotNull(message = "El ID del usuario es obligatorio")
    private Integer userId;

    @NotNull(message = "La fecha es obligatoria")
    @FutureOrPresent(message = "La fecha no puede ser en el pasado")
    private LocalDate date;

    @NotNull(message = "La hora es obligatoria")
    private LocalTime hour;

    @NotBlank(message = "El estado no puede estar vacío")
    @Pattern(regexp = "^(PENDING|CONFIRMED|CANCELLED)$",
             message = "El estado debe ser PENDING, CONFIRMED o CANCELLED")
    private String status;

    // Opcional: IDs de resultados asociados
    private List<Integer> matchResultIds;
	
	
	
}
