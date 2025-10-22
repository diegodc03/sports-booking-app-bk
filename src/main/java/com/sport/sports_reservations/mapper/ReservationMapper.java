package com.sport.sports_reservations.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.sport.sports_reservations.booking.model.CityDTO;
import com.sport.sports_reservations.booking.model.ReservationDTO;
import com.sport.sports_reservations.booking.model.SportDTO;


@Mapper
public interface ReservationMapper {
	
    List<ReservationDTO> findAll();

    ReservationDTO findById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(ReservationDTO reservation);

    void update(ReservationDTO reservation);

    void delete(Integer id);
    
    List<SportDTO> findSportsByCityId(Integer cityId);

	List<CityDTO> findAllCities();
    
    List<CityDTO> findCitiesByUserId(Long userId);

}