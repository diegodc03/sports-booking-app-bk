package com.sport.sports_reservations.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sport.sports_reservations.auth.model.Role;
import com.sport.sports_reservations.auth.model.User;
import com.sport.sports_reservations.mapper.UserMapper;




@Configuration
public class AplicationConfig {

    private final UserMapper userRepository;
    
    public AplicationConfig(UserMapper userRepository) {
    			this.userRepository = userRepository;
    }

    @Bean
    public UserDetailsService userDetailsService(){
    	return username -> {
            User user = userRepository.findByEmail(username)
                            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            List<Role> roles = userRepository.findRolesByUserId(user.getId());
            user.setRole(roles);

            return user; 
        };
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
