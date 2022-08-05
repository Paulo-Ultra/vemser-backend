package br.com.vemser.pessoaapi.security;

import br.com.vemser.pessoaapi.entity.UsuarioEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String expiration;

    public String getToken(Authentication authentication) {
        UsuarioEntity usuarioEntity = (UsuarioEntity) authentication.getPrincipal();

        Date now = new Date();
        Date exp = new Date(now.getTime() + Long.valueOf(expiration)); //Um dia em milissegundos
//        Date exp = new Date(now.getTime() + 1 * 24 * 60 * 60 * 1000); //Um dia em milissegundos

        String token = Jwts.builder()
                .setIssuer("pessoa-apiSecurity")
                .claim(Claims.ID, usuarioEntity.getIdUsuario())
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

        return TokenAuthenticationFilter.BEARER + token;
    }

    public UsernamePasswordAuthenticationToken isValid(String token) {
        if(token == null){
            return null;
        }

        Claims payload = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        Integer idUsuario = payload.get(Claims.ID, Integer.class);
        if(idUsuario != null) {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(idUsuario, null, Collections.emptyList());

            return usernamePasswordAuthenticationToken;
        }

        return null;
    }
}
