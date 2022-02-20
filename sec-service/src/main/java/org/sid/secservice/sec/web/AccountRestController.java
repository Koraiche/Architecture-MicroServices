package org.sid.secservice.sec.web;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.sid.secservice.sec.JWTUtile;
import org.sid.secservice.sec.entities.AppRole;
import org.sid.secservice.sec.entities.AppUser;
import org.sid.secservice.sec.model.RoleUserForm;
import org.sid.secservice.sec.repository.AppUserRepository;
import org.sid.secservice.sec.service.AccountService;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class AccountRestController {
    private AccountService accountService;
    public AccountRestController(AccountService accountService){
        this.accountService  = accountService;
    }
    @GetMapping(path = "/users")
    @PostAuthorize("hasAuthority('USER')")
    public List<AppUser> appUsers(){
        return accountService.listUsers();
    }
    @PostMapping(path = "/users")
    @PostAuthorize("hasAuthority('ADMIN')")
    public AppUser saveUser(@RequestBody AppUser appUser){
        return this.accountService.addNewUser(appUser);
    }
    @PostMapping(path = "/roles")
    @PostAuthorize("hasAuthority('ADMIN')")
    public void saveRole(@RequestBody AppRole appRole){
        this.accountService.addNewRole(appRole);
    }
    @PostMapping(path = "/addRoleToUser")
    @PostAuthorize("hasAuthority('ADMIN')")
    public void addRoleToUser(@RequestBody RoleUserForm roleUserForm){
        this.accountService.addRoleToUser(roleUserForm.getUsername(),roleUserForm.getRolename());
    }
    @GetMapping(path="/refreshToken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String authToken = request.getHeader(JWTUtile.AUTH_HEADER);
        if(authToken!=null && authToken.startsWith(JWTUtile.PREFIXE)){
            try {
                String refreshToken = authToken.substring(JWTUtile.PREFIXE.length());
                Algorithm algorithm = Algorithm.HMAC256(JWTUtile.SECRET);
                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(refreshToken);
                String username = decodedJWT.getSubject();
                AppUser usr = accountService.loadUserByUserName(username);
                String jwtAccessToken = JWT.create()
                        .withSubject(usr.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis()  + JWTUtile.EXPIRE_ACCESS_TOKEN))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", usr.getAppRoles().stream().map(r->r.getRoleName()).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String,String> idToken = new HashMap<>();
                idToken.put("access-token",jwtAccessToken);
                idToken.put("refresh-token", refreshToken);
                response.setContentType("application/json");
                new ObjectMapper().writeValue(response.getOutputStream(), idToken);
            }catch(Exception e){
                throw e;
            }
        }
        else{
            throw new RuntimeException("Refresh token required");
        }

    }
    @GetMapping(path = "/profile")
    public AppUser profile(Principal principal){
        return accountService.loadUserByUserName(principal.getName());
    }
}

