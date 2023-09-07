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
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/first")
public class FirstController {

    @Inject
    @Claim(standard = Claims.full_name)
    String fullName;

    @Inject
    @RestClient
    ISecondController secondController;

    @GET
    @Path("/somar")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed({"Admin"})
    public Integer somar(@QueryParam("value1") Integer value1, @QueryParam("value2") Integer value2) {
        return secondController.getSoma(value1, value2);
    }
}
