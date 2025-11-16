package com.sport.sports_reservations.booking.sports.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sport.sports_reservations.booking.sports.model.SportDTO;

@Repository("sportMapper")
public interface SportMapper {
	
	
	@Select("""
			SELECT 
	        	s.sport_id as sportId, 
	        	s.sport_name as sportName, 
	        	s.max_players as maxPlayers
	        FROM sports s
	        JOIN city_sports cs ON cs.sport_id = s.sport_id
	        WHERE cs.city_id = #{cityId}
			""")
	List<SportDTO> findSportsByCityId(Integer cityId);
}	
