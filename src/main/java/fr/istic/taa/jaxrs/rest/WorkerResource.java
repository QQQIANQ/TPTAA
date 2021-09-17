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
}
