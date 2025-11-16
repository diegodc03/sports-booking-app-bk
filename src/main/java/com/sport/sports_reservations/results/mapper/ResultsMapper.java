package com.sport.sports_reservations.results.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sport.sports_reservations.booking.sports.model.SportDTO;
import com.sport.sports_reservations.results.model.MatchResultDTO;

public interface ResultsMapper {

	
	@Select("""
			SELECT
			    id,
			    facility_name,
			    city_name,
			    sport_name,
			    date,
			    hour,
			    result AS match_result 
			FROM reservations
			LEFT JOIN match_results ON id = reservation_id
			LEFT JOIN facilities ON facilities.facility_id = reservations.id
			LEFT JOIN sports ON sports.sport_id = facilities.sport_id
			LEFT JOIN cities ON cities.city_id = facilities.city_id
			WHERE user_id = #{UserId}
			    AND status = 'PENDING'
			""")
	List<SportDTO> findReservationsByUser(Integer UserId);
	
	
	@Insert("""
			INSERT INTO match_results(reservation_id, result)
			VALUES(#{reservation_id}, #{result})
		""")
	void insertMatchResult(MatchResultDTO matchResult);
	
	
	
	
}
