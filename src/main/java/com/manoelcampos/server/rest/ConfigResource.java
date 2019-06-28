package com.manoelcampos.server.rest;

import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/config")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConfigResource {

    @ConfigProperty(name = "greeting.message")
    String message;

    @GET
    @Path("greeting")
    public String greeting() {
        return message;
    }

    @GET
    @Path("{property}")
    public String getProperty(@PathParam("property") String property) {
        return ConfigProvider.getConfig().getValue(property, String.class);
    }
}
