package com.sport.sports_reservations.booking.facility.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sport.sports_reservations.booking.facility.model.FacilityDTO;

@Mapper
public interface FacilityMapper {
	
	@Select("""
	        SELECT 
	            f.facility_id AS facilityId,
	            f.facility_name AS facilityName
	        FROM facilities f
	        WHERE f.city_id = #{cityId} AND f.sport_id = #{sportId}
	        """)
	    
	List<FacilityDTO> findAllByCityId(int cityId, int sportId);
	
}
