package com.sport.sports_reservations.booking.reservations.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;

import com.sport.sports_reservations.booking.reservations.model.CreateReservationDTO;
import com.sport.sports_reservations.booking.reservations.model.GuestUserDTO;
import com.sport.sports_reservations.booking.reservations.model.ReservationDTO;

@Mapper
public interface ReservationMapper {
    
	@Select("""
		    SELECT 
		        r.id AS reservation_id,
		        r.date,
		        r.hour,
		        r.status,

		        f.facility_id,
		        f.facility_name,

		        c.city_id,
		        c.city_name,

		        s.sport_id,
		        s.sport_name
		    FROM reservations r
		    JOIN facilities f ON r.facility_id = f.facility_id
		    JOIN cities c ON f.city_id = c.city_id
		    JOIN sports s ON f.sport_id = s.sport_id
		""")
		@Results(id = "ReservationResultMap", value = {
		    @Result(property = "id", column = "reservation_id"),
		    @Result(property = "date", column = "date"),
		    @Result(property = "hour", column = "hour"),
		    @Result(property = "status", column = "status"),
		    @Result(property = "facility.facilityId", column = "facility_id"),
		    @Result(property = "facility.facilityName", column = "facility_name"),
		    @Result(property = "facility.city.cityId", column = "city_id"),
		    @Result(property = "facility.city.cityName", column = "city_name"),
		    @Result(property = "facility.sport.sportId", column = "sport_id"),
		    @Result(property = "facility.sport.sportName", column = "sport_name")
		})
	List<ReservationDTO> findAllReservations();

	
    ReservationDTO findById(Integer id);

    @Insert("""
            INSERT INTO reservations (facility_id, user_id, date, hour, status)
            VALUES (#{facilityId}, #{userId}, #{date}, #{dateTime}, 'PENDING')
        """)
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    Long insertReservation(CreateReservationDTO params);
    
    @Insert({
        "<script>",
        "INSERT INTO guest_users (reservation_id, username, surname, telephone) VALUES",
        "<foreach collection='guests' item='guest' separator=','>",
        "(#{reservationId}, #{guest.username}, #{guest.surname}, #{guest.telephone})",
        "</foreach>",
        "</script>"
    })
    void insertGuests(@Param("reservationId") Long reservationId,
                      @Param("guests") List<GuestUserDTO> guests);
    
    

    void update(ReservationDTO reservation);

    void delete(Integer id);
}
