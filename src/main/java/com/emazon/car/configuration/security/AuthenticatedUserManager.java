package com.emazon.car.configuration.security;

import com.emazon.car.domain.spi.IAuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Map;

public class AuthenticatedUserManager implements IAuthenticationManager {

    @Override
    public String getEmailUser(){
        JwtAuthenticationToken authentication =
                (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        Map<String, Object> claims = authentication.getToken().getClaims();

        return claims.get("userEmail").toString();
    }

}
