package org.sid.secservice.sec.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.sid.secservice.sec.JWTUtile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JWTAuthenticationFilters extends UsernamePasswordAuthenticationFilter {
    AuthenticationManager authenticationManager;
    public JWTAuthenticationFilters(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("Attempt authentication");
        String usr = request.getParameter("username");
        String pwd = request.getParameter("password");
        System.out.println(usr + " " + pwd);
        UsernamePasswordAuthenticationToken  authenticationToken = new UsernamePasswordAuthenticationToken(usr,pwd);
        return this.authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        System.out.println("Successful authentication");
        User usr = (User) authResult.getPrincipal();
        Algorithm algo1 = Algorithm.HMAC256(JWTUtile.SECRET);
        String jwtAccessToken = JWT.create()
                .withSubject(usr.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()  + JWTUtile.EXPIRE_ACCESS_TOKEN))
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles", usr.getAuthorities().stream().map(ga->ga.getAuthority()).collect(Collectors.toList()))
                .sign(algo1);
        String jwtRefreshToken = JWT.create()
                .withSubject(usr.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()  + JWTUtile.EXPIRE_REFRESH_TOKEN))
                .withIssuer(request.getRequestURL().toString())
                .sign(algo1);
        Map<String,String> idToken = new HashMap<>();
        idToken.put("access-token",jwtAccessToken);
        idToken.put("refresh-token", jwtRefreshToken);
        response.setContentType("application/json");
        //response.setHeader("Authorization", jwtAccessToken);
        new ObjectMapper().writeValue(response.getOutputStream(), idToken);
        //super.successfulAuthentication(request, response, chain, authResult);
    }
}
