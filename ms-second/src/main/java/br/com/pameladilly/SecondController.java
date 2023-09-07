package br.com.pameladilly;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;

@Path("/second")
public class SecondController {

    @Inject
    @Claim(standard = Claims.email)
    String email;

    @GET
    @Path("/somar")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed({"Admin"})
    public Integer getSoma(@QueryParam("value1") Integer value1, @QueryParam("value2") Integer value2) {
        return value1 + value2;
    }
}
