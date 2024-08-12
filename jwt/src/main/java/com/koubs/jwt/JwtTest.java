package com.koubs.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
//import javax.xml.bind.DatatypeConverter;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * <a href="https://developer.okta.com/blog/2018/10/31/jwts-with-java">Tutorial: Create and Verify JWTs in Java——okta</a>
 * @author KouBeisi
 * @since 2021/9/7
 */
public class JwtTest {

    private static final byte[] BYTES = new byte[]{-122, 75, -40, 69, -123, -17, -74, -53, 39, -60, -66, 104, 28, -65, 55, 99, 37, -105, 114, 72, 124, 118, -50, -37, 25, -27, -83, -43, -55, -20, -32, 15};

    @Test
    @DisplayName("SecretKey生成")
    void secretKey() {
        // 方法一
        SecretKey secretKey1 = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        System.out.println(secretKey1.getClass());
        System.out.println(Arrays.toString(secretKey1.getEncoded()));
        System.out.println(secretKey1.getFormat());
        System.out.println(secretKey1.getAlgorithm());
        // 方法二
        final SecretKey secretKey2 = Keys.hmacShaKeyFor(BYTES);
        System.out.println(secretKey2.getClass());
        System.out.println(Arrays.toString(secretKey2.getEncoded()));
        System.out.println(secretKey2.getFormat());
        System.out.println(secretKey2.getAlgorithm());
        // 方法三
        final SecretKeySpec secretKey3 = new SecretKeySpec(BYTES, "HmacSHA256");
        System.out.println(secretKey2.equals(secretKey3));
    }

    @DisplayName("创建JWT")
    @ParameterizedTest
    @MethodSource(value = "secretKeySource")
    void create(SecretKey secretKey) {
        final String jws = Jwts.builder().setSubject("Joe").signWith(secretKey).compact();
        System.out.println(jws);
    }

    @ParameterizedTest
    @MethodSource(value = "secretKeySource")
    @DisplayName("验证JWT")
    void verify(SecretKey secretKey) {
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKb2UifQ.mpL9HZyVrlVl7Gqw-NGX7nljOdCHB3FsO5YcqpSqn7M";
        final JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(secretKey).build();
        final Jws<Claims> claimsJws = jwtParser.parseClaimsJws(jwt);
        System.out.println(claimsJws.getBody());
        System.out.println(claimsJws.getBody().getSubject());
        System.out.println(claimsJws.getHeader());
        System.out.println(claimsJws.getSignature());
    }


    static Stream<SecretKey> secretKeySource() {
        final SecretKey secretKey = Keys.hmacShaKeyFor(BYTES);
        return Stream.of(secretKey);
    }
}
