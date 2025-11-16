package com.sport.sports_reservations.booking.city.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sport.sports_reservations.booking.city.model.CityDTO;

@Mapper
public interface CityMapper {
	
	List<CityDTO> findAllCities();
    
	
	@Select("""
			SELECT DISTINCT
				c.city_id as cityId, 
				c.city_name as cityName
			FROM cities c
			LEFT JOIN user_cities uc ON uc.city_id = c.city_id
			WHERE c.public_access = true OR uc.user_id = #{userId}""")
    List<CityDTO> findCitiesByUserId(Long userId);
}
