package com.manoelcampos.server.rest;

import com.manoelcampos.server.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @GET
    @Path("{id}")
    public User findById(@PathParam("id") long id) {
        return new User(id, "Manoel Campos");
    }
}
