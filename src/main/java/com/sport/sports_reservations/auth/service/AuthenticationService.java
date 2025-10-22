package com.sport.sports_reservations.auth.service;


import lombok.Builder;
import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sport.sports_reservations.auth.dto.AuthenticacionRequest;
import com.sport.sports_reservations.auth.dto.AuthenticationResponse;
import com.sport.sports_reservations.auth.dto.RegisterRequest;
import com.sport.sports_reservations.auth.model.UserDTO;
import com.sport.sports_reservations.config.JwtService;
import com.sport.sports_reservations.mapper.UserMapper;
import com.sport.sports_reservations.mapper.RoleMapper;


@Service
@Builder
public class AuthenticationService {
    private final UserMapper userMapper;
    private final RoleMapper roleMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserMapper userMapper, RoleMapper roleMapper, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(RegisterRequest request) {
    	var role = roleMapper.findByRoleName("USER");
    	
    	UserDTO user = new UserDTO();
    	user.setFirstname(request.getFirstname());
    	user.setLastName(request.getLastname());
    	user.setEmail(request.getEmail());
    	user.setPassword(passwordEncoder.encode(request.getPassword()));
    	user.setTelephone(request.getTelephone());
    	user.setRoles(List.of(role));
    	
        userMapper.insert(user);
       
        if (role != null) {
        	userMapper.insertUserRole(user.getId(), role.getId());
        } else {
            throw new RuntimeException("No existe el rol: " + "USER");
        }
        
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticacionRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
            )
        );
        var user = userMapper.findByEmail(request.getEmail())
                .orElseThrow();
        var roles = userMapper.findRolesByUserId(user.getId());
        user.setRoles(roles);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}