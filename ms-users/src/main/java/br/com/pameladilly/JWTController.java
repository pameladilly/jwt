package br.com.pameladilly;

import io.smallrye.jwt.build.Jwt;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperties;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.jwt.Claims;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

@Path("/jwt")
public class JWTController {

    @ConfigProperty(name = "jwt.full-name")
    public String JwtFullName;

    @ConfigProperty(name = "jwt.email")
    public String JwtEmail;

    public JWTController() {
    }

    @GET
    @PermitAll
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String getJWT() {

        return Jwt.issuer("https://localhost:8443")
                .upn(JwtEmail)
                .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                .claim(Claims.full_name, JwtFullName)
                .claim(Claims.email, JwtEmail)
                .innerSign()
                .encrypt();
    }
}
