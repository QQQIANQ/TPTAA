package fr.istic.taa.jaxrs.rest;


import fr.istic.taa.jaxrs.dao.generic.UserDAO;
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
     @Path("/{id}")
     @Produces(MediaType.APPLICATION_JSON)
     public User getUserById(@PathParam("id") Long id){
        UserDAO dao = new UserDAO();
        return dao.findOne(id);
     }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteUser(@PathParam("id") Long id)  {
        UserDAO dao = new UserDAO();
        dao.delete(dao.findOne(id));
        return Response.ok().entity("SUCCESS").build();
    }

/*

    @POST
    @Path("/add")
    @Consumes({"application/json"})
    public Response addUser(@PathParam("name") String name,@PathParam("birthday") Date birthday){

        User user = new User(name, birthday);
        UserDAO userDAO = new UserDAO();
        userDAO.save(user);
        return Response.ok().entity("SUCCESS").build();
    }
*/

    @POST
    @Path("/add")
    @Consumes("application/json")
    public Response addUser(
            @Parameter(description = "User object that needs to be added to the store", required
                    = true) User user) {
        UserDAO userDAO = new UserDAO();
        userDAO.save(user);
        return Response.ok().entity("SUCCESS").build();
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    public Response updateUser(
            @Parameter(description = "User object that needs to be update to the store", required
                    = true) User user) {
        UserDAO userDAO = new UserDAO();
        userDAO.update(user);
        return Response.ok().entity("SUCCESS").build();
    }
}
