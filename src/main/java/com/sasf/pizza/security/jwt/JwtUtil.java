package com.sasf.pizza.security.jwt;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Component;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Component
public class JwtUtil {
    private static String SECRET_KEY = "4ndr3s_p1zz4";
    private static Algorithm ALGORITHM  = Algorithm.HMAC256(SECRET_KEY);

    public String create(String username){
        return JWT.create()
                .withSubject(username)
                .withIssuer("andres-pizza")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(15)))
                .sign(ALGORITHM);
    }

    public boolean isValid(String jwt){
        try{
            JWT.require(ALGORITHM)
                .build()
                .verify(jwt); 
            return true;

        } catch (JWTVerificationException e){
            return false;
        }
    }

    public String getUsername(String jwt){
        return   JWT.require(ALGORITHM)
                    .build()
                    .verify(jwt)
                    .getSubject();
    }
}
