package dev.rpmhub;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;

@Path("/api")
public class Start {

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy";
    }

    @POST
    @Path("/kmh2mih")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String kmh2mih(@FormParam("kmh") double kmh) {
        double mih = kmh * 0.621;
        return String.format("%.3f", mih);
    }

    @GET
    @Path("/no2kmh/{no}")
    @Produces(MediaType.APPLICATION_JSON)
    public String no2kmh(@PathParam("no") double no) {
        var kmh = no * 1.852;
        return String.format("%.3f", kmh);
    }
}
