package com.maitheen.authservice;


import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * JwtTokenUtil
 */
public class JwtTokenUtil {
    private static final String SERECT_KEY="THIS_THIS_IS_MYsCRECTkEY"; 
public String generateJWTTockeString(String userName){
    return  Jwts.builder()
    .setSubject(userName)
    .setIssuedAt(new Date())
    .setExpiration(new Date(System.currentTimeMillis() + 86400000))
    .signWith(SignatureAlgorithm.HS512, SERECT_KEY)
    .compact();
} 
public Claims getClaimsFromToken(String token) {
    return Jwts.parser()
            .setSigningKey(SERECT_KEY)
            .parseClaimsJws(token)
            .getBody();
}
}