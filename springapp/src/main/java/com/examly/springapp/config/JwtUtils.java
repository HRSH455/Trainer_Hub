package com.examly.springapp.config;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String jwtSecret;

    private static final Logger logger=LoggerFactory.getLogger(JwtUtils.class);

    public static final String JWT_HEADER = "Authorization";
    private final int jwtExpirationMs = 86400000;

    private SecretKey key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(jwtSecret.getBytes()); 
    }

    

    public String generateToken(UserDetails userDetails,String name,String email,String role,long id) {

        logger.info("token generated");

        Map<String,Object>claims=new HashMap<>();

        // claims.put("username",userDetails.getUsername() );
        claims.put("name", name);
        claims.put("email",email);
        claims.put("role", role);
        claims.put("userId", id);

        
        return Jwts.builder()
        .setClaims(claims)
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis()+jwtExpirationMs))
        .signWith(key)
        .compact();
        
    }

    public String extractUsername(String token) {

        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails) {

        logger.error("token is valid:{}",token);
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token)); 
    }

    public boolean isTokenExpired(String token) {
        Date expiration = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getExpiration();
        return expiration.before(new Date());
    }

}