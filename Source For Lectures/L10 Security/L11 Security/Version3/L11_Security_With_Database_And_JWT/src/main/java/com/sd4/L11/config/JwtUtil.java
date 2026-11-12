
package com.sd4.L11.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

/**
 * Utility class for handling JSON Web Tokens (JWT), including token creation,
 * validation, and extraction of claims such as username and expiration date.
 */
@Component
public class JwtUtil {

    //Ideally, this secret should be stored in an environment variable.
    //Generate a random 256-bit secret key for signing JWTs and encode it as Base64.
    String secret = Encoders.BASE64.encode(
            Keys.secretKeyFor(SignatureAlgorithm.HS256).getEncoded()
    );

    //Convert the Base64 secret into a cryptographic signing key.
    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * Extracts the username from the JWT.
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Extracts the expiration date from the JWT.
     */
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * Extracts a specific claim from the JWT using a provided function.
     */
    public <T> T extractClaim(String token,
                              Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Extracts all claims from the JWT.
     */
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    /**
     * Checks if the token is expired.
     */
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
     * Generates a JWT for the given username with a set expiration time.
     */
    public String generateToken(String username) {

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()
                        + 1000 * 60 * 60 * 10)) //10 hours
                .signWith(getSigningKey())
                .compact();
    }

    /**
     * Validates the token by checking the username and expiration date.
     */
    public Boolean validateToken(String token, String username) {

        final String usernameFromToken = extractUsername(token);

        return (username.equals(usernameFromToken)
                && !isTokenExpired(token));
    }
}
