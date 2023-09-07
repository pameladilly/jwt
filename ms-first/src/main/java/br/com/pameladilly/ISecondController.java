package br.com.pameladilly;


import io.quarkus.oidc.token.propagation.AccessToken;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient()
@AccessToken
public interface ISecondController {

    @GET
    @Path("/second/somar")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed({ "Admin" })
    public Integer getSoma(@QueryParam("value1") Integer value1, @QueryParam("value2") Integer value2);
}
