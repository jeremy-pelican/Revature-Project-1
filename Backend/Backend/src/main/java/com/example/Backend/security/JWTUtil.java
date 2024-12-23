package com.example.Backend.security;

//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

//@Component
public class JWTUtil{
//    @Value("${jwt.secret}")
//    private String secret;
//
//    @Value("${jwt.expiration}")
//    private Long expiration;

//    public String generateToken(String username) throws IllegalArgumentException, JWTCreationException {
//        return JWT.create()
//                .withSubject("Account Details")
//                .withClaim("username", username)
//                .withIssuedAt(new Date())
//                .withIssuer("PROJECT_1_BACKEND")
//                .sign(Algorithm.HMAC256(secret));
//    }
//    public String generateToken(String username) {
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + expiration))
//                .signWith(SignatureAlgorithm.HS512, secret)
//                .compact();
//    }

//    public Boolean validateToken(String token, String username) {
//        final String tokenUsername = getUsernameFromToken(token);
//        return (tokenUsername.equals(username) && !isTokenExpired(token));
//    }

//    public String getUsernameFromToken(String token) {
//        return getClaimFromToken(token, Claims::getSubject);
//    }
//
//    public Date getExpirationDateFromToken(String token) {
//        return getClaimFromToken(token, Claims::getExpiration);
//    }
//
//    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = getAllClaimsFromToken(token);
//        return claimsResolver.apply(claims);
//    }
//
//    private Claims getAllClaimsFromToken(String token) {
//        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//    }

//    private Boolean isTokenExpired(String token) {
//        final Date expiration = getExpirationDateFromToken(token);
//        return expiration.before(new Date());
//    }

//    public String validateTokenAndRetrieveSubject(String token) throws JWTVerificationException {
//        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
//                .withSubject("Account Details")
//                .withIssuer("PROJECT_1_BACKEND")
//                .build();
//        DecodedJWT jwt = verifier.verify(token);
//        return jwt.getClaim("username").asString();
//    }
}
