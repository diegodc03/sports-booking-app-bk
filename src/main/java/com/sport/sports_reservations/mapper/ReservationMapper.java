package com.sport.sports_reservations.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sport.sports_reservations.booking.model.Reservation;

@Mapper
public interface ReservationMapper {
	
	@Select("SELECT * FROM reservations")
    List<Reservation> findAll();

    @Select("SELECT * FROM reservations WHERE id = #{id}")
    Reservation findById(Integer id);

    @Insert("INSERT INTO reservations (facility_id, user_id, date, hour, status) " +
            "VALUES (#{facility.id}, #{user.id}, #{date}, #{hour}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Reservation reservation);

    @Update("UPDATE reservations SET facility_id=#{facility.id}, user_id=#{user.id}, date=#{date}, hour=#{hour}, status=#{status} WHERE id=#{id}")
    void update(Reservation reservation);

    @Delete("DELETE FROM reservations WHERE id = #{id}")
    void delete(Integer id);
}
