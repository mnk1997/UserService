package com.assignment.userservice.configurations;

import com.assignment.userservice.models.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Configuration
public class JwtConfig {
    private String jwtSecret = "4261656C64756E67";
    private long jwtExpirationMs = 60000;
    //we must ensure the key string is Base64 encoded before generating a secret key from it.
    //because the secret may be poorly formed, and the string may contain non-UTF-8 characters.
    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(this.jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    //using the SecretKey instance over the Key instance is advisable
    // because the new method named verifyWith() to verify the token accepts
    // the SecretKey type as a parameter.
   private SecretKey getSigningKeyUsingSecretKeyInstance() {
        return Jwts.SIG.HS256.key().build();
    }


   public String generateJwtToken(User user) {


        return Jwts.builder()
                .subject(user.getUsername()+"|"+user.getEmail())
                .claim("roles",user.getRoles().toString())
                .issuedAt(new Date())
                .expiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(getSigningKeyUsingSecretKeyInstance())
                .compact();
    }

}
