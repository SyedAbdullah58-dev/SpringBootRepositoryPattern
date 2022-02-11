package com.example.demo.jwt;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
public class UserAuthFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final JwtConfig jwtConfig;

    public UserAuthFilter(AuthenticationManager authenticationManager, JwtConfig jwtConfig) {
        this.authenticationManager = authenticationManager;
        this.jwtConfig = jwtConfig;
    }
    @Override
    @Bean
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            UserCredential userCredential = new ObjectMapper().readValue(request.getInputStream(), UserCredential.class);
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    userCredential.getUsername(),
                    userCredential.getPassword()
            );
            Authentication authenticate = authenticationManager.authenticate(authentication);
            return authenticate;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        String token = Jwts.builder().setSubject(authResult.getName()).
                claim("authorities", authResult.getAuthorities()).
                setIssuedAt(new java.util.Date()).
                setExpiration(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .signWith(SignatureAlgorithm.HS256,"secret").compact();
        response.addHeader(jwtConfig.getAuthorization(), jwtConfig.getTokenPrefix()+token);

    }
}
