package org.personal.exam_portal_backend.common.configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/** created by: maharjananil created on: 10/12/2023 */
@Service
public class JwtService {
  private static final String SECRET_KEY =
      "58bc48ea89379fb07e4bc0be59b82d82fa6d3ff804776e477f6534ba84028250";

  public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
    return Jwts.builder()
        .setClaims(extraClaims)
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
        .signWith(this.getSignatureKey(), SignatureAlgorithm.HS256)
        .compact();
  }

  public String generateToken(UserDetails userDetails) {
    return this.generateToken(new HashMap<>(), userDetails);
  }

  public boolean isTokenValid(String jwtToken, UserDetails userDetails) {
    final String username = extractUsername(jwtToken);
    return username.equals(userDetails.getUsername()) && isTokenExpired(jwtToken);
  }

  private boolean isTokenExpired(String jwtToken) {
    return extractExpiration(jwtToken).after(new Date());
  }

  private Date extractExpiration(String jwtToken) {
    return this.extractClaim(jwtToken, Claims::getExpiration);
  }

  public String extractUsername(String jwtToken) {
    return extractClaim(jwtToken, Claims::getSubject);
  }

  public <T> T extractClaim(String jwtToken, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(jwtToken);
    return claimsResolver.apply(claims);
  }

  private Claims extractAllClaims(String jwtToken) {
    return Jwts.parserBuilder()
        .setSigningKey(this.getSignatureKey())
        .build()
        .parseClaimsJws(jwtToken)
        .getBody();
  }

  private Key getSignatureKey() {
    byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(keyBytes);
  }
}
