package edu.calvin.cs262.server;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
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
	
	@GET
	@Path("/default")
	@Produces(MediaType.APPLICATION_JSON)
	public Player retrievePlayer() {
		return new Player();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Player retrievePlayer(@PathParam("id") int id) {
		return Player.retrieve(id);
	}
}



