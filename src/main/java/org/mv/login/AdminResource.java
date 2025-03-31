package org.mv.login;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.mv.auth.jwtService;

@Path("/api/admin")
public class AdminResource {

    @Inject
    jwtService service;

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.TEXT_PLAIN)
    public String adminResource() {
//        String jwt=service.generateJWT();
//        return Response.ok("admin"+jwt).build();
        return "admin";
    }
}
