package com.suportChat.project.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.suportChat.project.model.entity.AdmUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class TokenConfig {

    @Value("{jwt.secret}")
    private String secret;


    public String generateToken(AdmUser user){
        Algorithm algorithm = Algorithm.HMAC256(secret);

        try {
            String token = JWT.create()
                    .withIssuer("queue-ticket")
                    .withSubject(user.getEmail())
                    .withExpiresAt(generationExpiration())
                    .withIssuedAt(Instant.now())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException e){
            throw new RuntimeException("Error while generate token: " + e);
        }

    }

    private Instant generationExpiration(){
        return LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.of("-03:00"));
    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e){
            throw new RuntimeException("Error while validate token: " + e);
        }
    }
}
