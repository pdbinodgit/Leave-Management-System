package com.LMS.LMS.auth.jwt;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {

    private final String KEY="mysupersecretjwtkeyforhs2561234561234567986654323edcvgtyhbnju";
    private final java.security.Key signingKey =
            Keys.hmacShaKeyFor(KEY.getBytes(StandardCharsets.UTF_8));
    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis()+1000*60*60)
                )
                .signWith(signingKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsernameFromToken(String token){
        return Jwts.parserBuilder()
                .setSigningKey(signingKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

}
