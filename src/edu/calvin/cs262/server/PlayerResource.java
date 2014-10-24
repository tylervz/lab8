package edu.calvin.cs262.server;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/player")               // On some platforms, I had to remove the "/" here.
public class PlayerResource {

	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String helloRest() {
		return "Hello, REST server!";
	}
}