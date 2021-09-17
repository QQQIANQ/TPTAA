package fr.istic.taa.jaxrs.rest;


import fr.istic.taa.jaxrs.dao.generic.*;
import fr.istic.taa.jaxrs.domain.*;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.Date;
import java.util.List;

@Path("/worker")
@Produces({"application/json"})
public class WorkerResource {
    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Worker> getAllUser(){
        WorkerDao workerDao = new WorkerDao();
        return workerDao.getAllWorker();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Worker getJobById(@PathParam("id") Long id){
    	WorkerDao workerDao = new WorkerDao();
       return workerDao.findOne(id);
    }
    
    @DELETE
    @Path("/delete/{id}")
    public Response deleteWorker(@PathParam("id") Long id)  {
        WorkerDao dao = new WorkerDao();
        dao.delete(dao.findOne(id));
        return Response.ok().entity("SUCCESS").build();
    }
	
	@POST
    @Path("/add")
    @Consumes("application/json")
    public Response addWorker(
            @Parameter(description = "Worker object that needs to be added to the store", required
                    = true) Worker worker) {
		WorkerDao dao = new WorkerDao();
		dao.save(worker);
        return Response.ok().entity("SUCCESS").build();
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    public Response updateWorker(
            @Parameter(description = "Worker object that needs to be update to the store", required
                    = true) Worker worker) {
    	WorkerDao dao = new WorkerDao();
    	dao.update(worker);
        return Response.ok().entity("SUCCESS").build();
    }
}
