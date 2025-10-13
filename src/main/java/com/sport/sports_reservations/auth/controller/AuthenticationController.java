package com.sport.sports_reservations.auth.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sport.sports_reservations.auth.dto.AuthenticacionRequest;
import com.sport.sports_reservations.auth.dto.AuthenticationResponse;
import com.sport.sports_reservations.auth.dto.RegisterRequest;
import com.sport.sports_reservations.auth.service.AuthenticationService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    
    public AuthenticationController(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}
    
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticacionRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
