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
import java.util.Map;
import java.util.function.Function;

/**
 * Utility class for handling JSON Web Tokens (JWT), including token creation, validation,
 * and extraction of claims such as username and expiration date.
 *
 * A claim is a piece of information embedded within a JWT that conveys details about the user or token, such as username, expiration.
 *
 * <p>This class is responsible for creating a JWT for a given username, extracting claims
 * like username and expiration from a token, and validating tokens against a stored secret key.</p>
 *
 * <p><strong>Note:</strong> The secret key should be stored securely and not directly in the code.</p>
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
     *
     * @param token the JWT from which to extract the username
     * @return the username embedded in the token
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Extracts the expiration date from the JWT.
     *
     * @param token the JWT from which to extract the expiration date
     * @return the expiration date of the token
     */
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * Extracts a specific claim from the JWT using a provided function.
     *
     * @param <T> the type of the claim
     * @param token the JWT from which to extract the claim
     * @param claimsResolver a function to resolve the desired claim from the token
     * @return the resolved claim
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
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
     *
     * @param token the JWT to check for expiration
     * @return true if the token is expired, false otherwise
     */
    public Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
     * Generates a JWT for the given username with a set expiration time.
     *
     * @param username the username to embed in the token
     * @return the generated JWT
     */
    public String generateToken(String username) {
        return Jwts.builder().setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 3)) // 3-minute expiration
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    /**
     * Validates the token by checking the username and expiration date.
     *
     * @param token the JWT to validate
     * @param username the username to compare against the token's embedded username
     * @return true if the token is valid and not expired, false otherwise
     */
    public Boolean validateToken(String token, String username) {
        final String usernameFromToken = extractUsername(token);
        return (username.equals(usernameFromToken) && !isTokenExpired(token));
    }

}
