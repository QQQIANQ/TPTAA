package fr.istic.taa.jaxrs.rest;


import fr.istic.taa.jaxrs.dao.generic.UserDAO;
import fr.istic.taa.jaxrs.domain.Pet;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.Date;
import java.util.List;

@Path("/user")
@Produces({"application/json"})
public class UserResource {

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUser(){
        UserDAO userDAO = new UserDAO();
        return userDAO.getAllUser();
     }

     @GET
     @Path("/{name}")
     @Produces(MediaType.APPLICATION_JSON)
     public User getUserByName(@PathParam("name") String name){
        UserDAO dao = new UserDAO();
        return dao.findByName(name);
     }

    @DELETE
    public Response deleteUser(@QueryParam("name") String name)  {
        UserDAO dao = new UserDAO();
        dao.delete(dao.findByName(name));
        return Response.ok().entity("SUCCESS").build();
    }

    @POST
    @Consumes("application/json")
    public Response addUser(
            @Parameter(description = "User object that needs to be added to the store", required
                    = true) User user) {
        UserDAO userDAO = new UserDAO();
        userDAO.save(user);
        return Response.ok().entity("SUCCESS").build();
    }
}
