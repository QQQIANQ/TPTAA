package fr.istic.taa.jaxrs.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.JobDao;
import fr.istic.taa.jaxrs.dao.generic.UserDAO;
import fr.istic.taa.jaxrs.domain.Job;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/job")
@Produces({"application/json"})
public class JobResource {
	
	@GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Job> getAllJob(){
		JobDao jobDAO = new JobDao();
        return jobDAO.findAll();
     }
	
	@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Job getJobById(@PathParam("id") Long id){
       JobDao dao = new JobDao();
       return dao.findOne(id);
    }
	
	@DELETE
    @Path("/delete/{id}")
    public Response deleteJob(@PathParam("id") Long id)  {
        JobDao dao = new JobDao();
        dao.delete(dao.findOne(id));
        return Response.ok().entity("SUCCESS").build();
    }
	
	@POST
    @Path("/add")
    @Consumes("application/json")
    public Response addJob(
            @Parameter(description = "Job object that needs to be added to the store", required
                    = true) Job job) {
		JobDao jDAO = new JobDao();
		jDAO.save(job);
        return Response.ok().entity("SUCCESS").build();
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    public Response updateJob(
            @Parameter(description = "Job object that needs to be update to the store", required
                    = true) Job job) {
    	JobDao jDAO = new JobDao();
    	jDAO.update(job);
        return Response.ok().entity("SUCCESS").build();
    }
    
}
