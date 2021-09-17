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

import fr.istic.taa.jaxrs.dao.generic.AppointmentDao;
import fr.istic.taa.jaxrs.dao.generic.WorkerDao;
import fr.istic.taa.jaxrs.domain.Appointment;
import fr.istic.taa.jaxrs.domain.Worker;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/Appointment")
@Produces({"application/json"})
public class AppointmentResource {
	@GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Appointment> getAllAppointment(){
        AppointmentDao dao = new AppointmentDao();
        return dao.findAll();
    }
	
	@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Appointment getAppointmentById(@PathParam("id") Long id){
		AppointmentDao dao = new AppointmentDao();
       return dao.findOne(id);
    }
	
	@DELETE
    @Path("/delete/{id}")
    public Response deleteAppointment(@PathParam("id") Long id)  {
		AppointmentDao dao = new AppointmentDao();
        dao.delete(dao.findOne(id));
        return Response.ok().entity("SUCCESS").build();
    }
	
	@POST
    @Path("/add")
    @Consumes("application/json")
    public Response addAppointment(
            @Parameter(description = "Appointment object that needs to be added to the store", required
                    = true) Appointment app) {
		AppointmentDao dao = new AppointmentDao();
		dao.save(app);
        return Response.ok().entity("SUCCESS").build();
    }
}
