package com.sport.sports_reservations.configApi;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Natasa Todorov Markovic
 */
@RestController
@RequestMapping("/api")
public class MeController {

    /** Public endpoint – quick connectivity/health check (no auth). */
    @GetMapping("/public/ping")
    public Map<String, String> ping() {
        return Map.of("status", "ok");
    }

    /**
     * Protected endpoint – requires a valid JWT (configured in SecurityConfig).
     * Returns a small subset of JWT claims useful to verify the login flow.
     */
    @GetMapping("/me")
    public Map<String, Object> me(@AuthenticationPrincipal Jwt jwt) {
        Map<String, Object> data = new LinkedHashMap<>();

        // Standard OIDC-ish claims (may be missing depending on IdP mapping)
        data.put("sub", jwt.getSubject());
        data.put("email", jwt.getClaimAsString("email")); // might be null if not included
        data.put("preferred_username", jwt.getClaimAsString("preferred_username"));

        // Token timing – useful for debugging expiry/clock skew
        data.put("issuedAt", jwt.getIssuedAt());
        data.put("expiresAt", jwt.getExpiresAt());

        // Keycloak realm roles typically live under realm_access.roles
        Map<String, Object> realmAccess = jwt.getClaimAsMap("realm_access");
        if (realmAccess != null) {
            Object raw = realmAccess.get("roles");
            if (raw instanceof List<?>) {
                List<String> roles = ((List<?>) raw).stream()
                        .filter(String.class::isInstance)
                        .map(String.class::cast)
                        .toList();
                data.put("roles", roles);
            }
        }

        return data;
    }

}