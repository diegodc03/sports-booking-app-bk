package com.sport.sports_reservations.utils;

import java.util.List;

import com.sport.sports_reservations.auth.model.Role;

public class RoleUtils {
	
	
	private RoleUtils() {} // Evita instanciación

    public static boolean hasRole(List<Role> roles, String roleName) {
        return roles != null && roles.stream()
                .anyMatch(r -> r.getRoleName().equalsIgnoreCase(roleName));
    }
}
