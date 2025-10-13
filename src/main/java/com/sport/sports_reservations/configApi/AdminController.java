package com.sport.sports_reservations.configApi;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Natasa Todorov Markovic

 * Example controller to demonstrate role-based access control with @PreAuthorize.
 * Requires the caller to have ROLE_ADMIN (mapped from Keycloak "realm_access.roles")
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    /*
      Example protected endpoint.
      @PreAuthorize("hasRole('ADMIN')") ensures only users with ROLE_ADMIN can access it.
      If the JWT does not contain "ADMIN" in realm_access.roles -> returns HTTP 403 Forbidden.
     */
    @GetMapping("/only")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminOnly() { return "ok - admin"; }
}