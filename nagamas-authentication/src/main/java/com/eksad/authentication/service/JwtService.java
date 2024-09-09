package com.eksad.authentication.service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    @Value("${jwt.private.key.path}")
    private Resource privateKeyResource;

    @Value("${jwt.public.key.path}")
    private Resource publicKeyResource;

    private final KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    private final Base64.Decoder decoder = Base64.getDecoder();

    private PrivateKey privateKey;
    private PublicKey publicKey;

    public JwtService() throws NoSuchAlgorithmException {
    }

    private PrivateKey getPrivateKey() throws Exception {
        if (this.privateKey == null) {
            try (InputStream inputStream = privateKeyResource.getInputStream()) {
                byte[] keyBytes = inputStream.readAllBytes();
                String privateKeyPEM = new String(keyBytes)
                        .replace("-----BEGIN PRIVATE KEY-----", "")
                        .replace("-----END PRIVATE KEY-----", "")
                        .replaceAll("\\s", "");

                byte[] decodedKey = decoder.decode(privateKeyPEM);
                PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decodedKey);
                this.privateKey = keyFactory.generatePrivate(spec);
            }
        }

        return this.privateKey;
    }

    private PublicKey getPublicKey() throws Exception {
        if (this.publicKey == null) {
            try (InputStream inputStream = publicKeyResource.getInputStream()) {
                byte[] keyBytes = inputStream.readAllBytes();
                String publicKeyPEM = new String(keyBytes)
                        .replace("-----BEGIN PUBLIC KEY-----", "")
                        .replace("-----END PUBLIC KEY-----", "")
                        .replaceAll("\\s", "");

                byte[] decodedKey = decoder.decode(publicKeyPEM);
                X509EncodedKeySpec spec = new X509EncodedKeySpec(decodedKey);
                this.publicKey = keyFactory.generatePublic(spec);
            }
        }

        return this.publicKey;
    }

    public boolean isValid(String token, UserDetails user) throws Exception {
        String username = extractUsername(token);
        return (username.equals(user.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) throws Exception {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) throws Exception {
        return extractClaim(token, Claims::getExpiration);
    }

    public String extractUsername(String token) throws Exception {
        return extractClaim(token, claims -> claims.get("username", String.class));
    }
    public <T> T extractClaim(String token, Function<Claims, T> resolver) throws Exception {
        Claims claims = extractAllClaims(token);
        return resolver.apply(claims);
    }
    private Claims extractAllClaims(String token) throws Exception {
        return Jwts
                .parser()
                .verifyWith(getPublicKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String generateToken(Map<String, Object> additionClaims) throws Exception {
         return  Jwts
                .builder()
                .claims(additionClaims)
                .issuedAt(new Date(System.currentTimeMillis()))
                .signWith(getPrivateKey())
                .compact();
    }

//    private SecretKey getSigninKey(){
//        byte[] keyBytes = Decoders.BASE64URL.decode(secretKey);
//        return Keys.hmacShaKeyFor(keyBytes);
//    }


}
