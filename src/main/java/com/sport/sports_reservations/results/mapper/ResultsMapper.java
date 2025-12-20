package com.sport.sports_reservations.results.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sport.sports_reservations.results.model.MatchResult;

public interface ResultsMapper {

	
	@Select("""

			SELECT
			    (r.date::text || ' ' || r.hour::text) AS "dateTime",
			    f.facility_name AS "facilityName", 
			    s.sport_name AS "sportName",
			    c.city_name AS "cityName",
			    COALESCE(mr.result, 'Pendiente') AS "result"
			    
			FROM public.reservations r
			JOIN public.facilities f ON r.facility_id = f.facility_id
			JOIN public.sports s ON f.sport_id = s.sport_id
			JOIN public.cities c ON f.city_id = c.city_id
			LEFT JOIN public.match_results mr ON r.id = mr.reservation_id
			
			WHERE r.user_id = #{userId}
			ORDER BY 
			    r.date DESC, r.hour DESC; -- Ordenar por fecha más reciente
			""")	
	List<MatchResult> findReservationsByUser(Long userId);
	
	
	
	@Insert("""
			INSERT INTO match_results(reservation_id, result)
			VALUES(#{reservation_id}, #{matchResult})
		""")
	void insertMatchResult(MatchResult matchResult);
	
	
	
	
}
