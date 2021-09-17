package fr.istic.taa.jaxrs.rest;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class rootService {

	@GET
	@Produces({MediaType.TEXT_HTML})
	public InputStream addUserTest()
	{
		String s="<p>Create User</p><br>" + 
				"Attention, les formulaires marchent que pour les servlets !"+
				"<FORM Method=\"GET\" Action=\"localhost:8000/user/getall\">" + 
				"    Name : 		<INPUT type=\"text\" size=\"20\" name=\"name\"><BR>" + 
				"    Birthday : 		<INPUT type=\"date\" name=\"birthday\"><BR>" + 
				"    <INPUT type=\"submit\" value=\"Send\">" + 
				"</FORM>";
		InputStream res=new ByteArrayInputStream( s.getBytes() );
		
		return res;
	}
}
