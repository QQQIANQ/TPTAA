package fr.istic.taa.jaxrs.rest;


import fr.istic.taa.jaxrs.domain.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Date;

@Path("/user")
@Produces({"application/json"})
public class UserResource {

    @GET
    @Path("/get")
    public User getUser(){

         User user = new User();
         user.setName("george");
         user.setDateNaissance(new Date());

         return user;
     }

}
