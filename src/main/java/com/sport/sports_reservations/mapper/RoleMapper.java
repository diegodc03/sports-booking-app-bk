package com.sport.sports_reservations.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.sport.sports_reservations.auth.model.Role;

@Mapper
public interface RoleMapper {
    @Select("SELECT id, role_name as roleName FROM roles WHERE role_name = #{roleName}")
    Role findByRoleName(String roleName);
    
    @Select("SELECT id, role_name as roleName FROM roles")
    List<Role> findAllRoles();
}
