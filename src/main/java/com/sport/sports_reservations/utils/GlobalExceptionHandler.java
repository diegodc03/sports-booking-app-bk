package com.sport.sports_reservations.utils;


import java.util.NoSuchElementException;

import javax.naming.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	/**
     * Captura la IllegalArgumentException (contraseñas no coinciden)
     * y la devuelve al cliente como un error HTTP 400 (Bad Request).
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
        // Devuelve el mensaje de la excepción (ej: "Las contraseñas no coinciden")
        // en el cuerpo de la respuesta.
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
    /**
     * Captura la RuntimeException (rol no encontrado).
     * La devuelve como un error HTTP 500 (Error Interno del Servidor),
     * ya que esto es un problema de configuración interna, no un error del usuario.
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntime(RuntimeException ex) {
        // Devuelve el mensaje de la excepción (ej: "No existe el rol: USER")
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
    /**
     * Captura fallos de autenticación (contraseña incorrecta o usuario no existe)
     * y devuelve un error HTTP 401 (Unauthorized).
     */
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException ex) {
        // En login, es mejor no decir si falló el usuario o la contraseña por seguridad.
        return new ResponseEntity<>("Credenciales de acceso inválidas", HttpStatus.UNAUTHORIZED); 
    }

    /**
     * Captura el .orElseThrow() si no se encuentra el usuario en la base de datos.
     * Aunque es raro después de la autenticación, devuelve un error HTTP 404.
     */
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException ex) {
        // Devuelve 404 (Not Found).
        return new ResponseEntity<>("El usuario no fue encontrado en el sistema", HttpStatus.NOT_FOUND);
    }
    

}
