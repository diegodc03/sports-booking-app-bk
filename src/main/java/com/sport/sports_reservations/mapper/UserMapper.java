package com.sport.sports_reservations.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sport.sports_reservations.auth.model.Role;
import com.sport.sports_reservations.auth.model.User;

@Mapper
public interface UserMapper {

    @Select("SELECT id, email, password, role_id FROM users WHERE email = #{email}")
    Optional<User> findByEmail(String email);

    @Insert("""
            INSERT INTO users(email, password, first_name, last_name, telephone)
            VALUES(#{email}, #{password}, #{firstname}, #{lastName}, #{telephone})
        """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);
    
    
    @Select("""
            SELECT r.id, r.role_name as roleName
            FROM roles r
            JOIN user_roles ur ON ur.role_id = r.id
            WHERE ur.user_id = #{userId}
        """)
        List<Role> findRolesByUserId(Integer userId);
    
    
    @Insert("""
            INSERT INTO user_roles(user_id, role_id)
            VALUES(#{userId}, #{roleId})
        """)
    void insertUserRole(@Param("userId") Integer userId, @Param("roleId") Integer roleId);
    
}