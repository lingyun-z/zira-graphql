package com.example.ziragraphql.util;

import com.example.ziragraphql.config.EssSettings;
import com.example.ziragraphql.config.error.UnauthenticatedAccessException;
import com.example.ziragraphql.entity.User;
import com.example.ziragraphql.entity.UserToken;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;

@Component
public class JWToKenUtil {
  @Autowired
  private EssSettings essSettings;

  private static final long MINUTE = 60 * 1000; // 1 minute

  public UserToken createUserToken(User user) {
    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    String secretKey = Base64.getEncoder().encodeToString(essSettings.getJwtTokenSecret().getBytes());
    Date expiration = new Date(System.currentTimeMillis() + essSettings.getUserTokenDuration() * MINUTE);

    JwtBuilder builder = Jwts.builder()
            .setExpiration(expiration)
            .setSubject("userToken")
            .setIssuer("zira-graphql")
            .setIssuedAt(new Date())
            .claim("id", user.getId())
            .claim("mail",user.getMail())
            .claim("name",user.getName())
            .signWith(signatureAlgorithm, secretKey);

    return new UserToken(builder.compact(), essSettings.getUserTokenDuration() * MINUTE);
  }

  public boolean isValidToken(String token) throws Exception {
    boolean result = true;
    try {
      Jwts.parser()
              .setSigningKey(Base64.getEncoder()
              .encodeToString(essSettings.getJwtTokenSecret().getBytes())).parseClaimsJws(token);
    } catch (Exception ex) {
      throw new UnauthenticatedAccessException("Unauthenticated");
    }
    return result;
  }

  public User parseToken(String token) throws Exception {
    User result;
    try {
      Jws<Claims> claims = Jwts.parser()
              .setSigningKey(Base64.getEncoder()
              .encodeToString(essSettings.getJwtTokenSecret().getBytes())).parseClaimsJws(token);
      Claims body = claims.getBody();

      result = new User(
              body.get("id",String.class),
              null,
              body.get("name",String.class),
              body.get("mail",String.class));
    } catch (Exception ex) {
      throw new UnauthenticatedAccessException("Unauthenticated");
    }
    return result;
  }
}
