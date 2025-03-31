package org.mv.login;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.SecurityContext;

import java.util.Base64;

@Path("/api/user")
public class UserResource {

    @GET
    @RolesAllowed("user")
    @Path("/me")
    public String me(@Context SecurityContext securityContext) {
        return securityContext.getUserPrincipal().getName();
    }

//    @GET
//    //@PermitAll
//    @RolesAllowed({"admin","user"})
//    @Path("/")
//    public String all(@Context SecurityContext securityContext) {
//        return "rol: "+securityContext.isUserInRole("user");
//    }

    @GET
    @RolesAllowed({"admin", "user"})
    public String getAuthInfo(@Context HttpHeaders headers) {
        // Obtener el header de Authorization
        String authHeader = headers.getHeaderString(HttpHeaders.AUTHORIZATION);

        String token=authHeader.substring(6);
            return token;
    }
}
