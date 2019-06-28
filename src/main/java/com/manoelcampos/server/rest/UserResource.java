package com.manoelcampos.server.rest;

import com.manoelcampos.server.dao.DAO;
import com.manoelcampos.server.model.User;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    @Inject
    DAO<User> dao;

    @GET
    @Path("{id}")
    public User findById(@PathParam("id") long id) {
        return dao.findById(id);
    }
}
