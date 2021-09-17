package fr.istic.taa.jaxrs;

import fr.istic.taa.jaxrs.dao.generic.*;
import fr.istic.taa.jaxrs.domain.*;
import io.undertow.Undertow;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import java.sql.Date;
import java.util.logging.Logger;

/**
 * RESTfull microservice, based on JAX-RS and JBoss Undertow
 *
 */
public class RestServer {

    private static final Logger logger = Logger.getLogger(RestServer.class.getName());

    public static void main( String[] args ) {

    	
    	//peuplerBDD();
    	
    	
        UndertowJaxrsServer ut = new UndertowJaxrsServer();

        TestApplication ta = new TestApplication();

        ut.deploy(ta);

        ut.start(
                Undertow.builder()
                        .addHttpListener(8000, "localhost")

        );

        logger.info("JAX-RS based micro-service running!");


    }
    
    
    public static void peuplerBDD() {
    	User u1=new User("Bob", new Date(99999999L));
    	User u2=new User("Georges",new Date(9999999999L));
    	Job j1= new Job("plombier",2500);
    	Worker w1= new Worker("Patrick",new Date(9999999999L),j1,15);
    	UserDAO uDAO=new UserDAO();
    	uDAO.save(u1);uDAO.save(u2);
    	JobDao jDAO=new JobDao();
    	jDAO.save(j1);
    	WorkerDao wDAO=new WorkerDao();
    	wDAO.save(w1);
    }
}
