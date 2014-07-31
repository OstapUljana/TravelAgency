package com.vz.jpa.facade;

import java.text.ParseException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import com.vz.jpa.dao.ClientDaoImpl;
import com.vz.jpa.entities.Client;

@Path("/change")
public class ChangePassword {
	@POST()
	// @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces("text/plain")
	static public Response UpdateClient(
				@FormParam("email") String email,
				@FormParam("password") String password,
				@FormParam("new_password") String password2) throws ParseException{
		ClientDaoImpl enterClient = new ClientDaoImpl();
		 Client client = enterClient.selectByEmailandPassword(email, password);
		/*Client client = new Client(email, password2);*/
		client.setPassword(password2);
		enterClient.update(client);
		return (Response.ok().entity(client).build()/*.getEntity().toString()*/);
		
		/*UserDaoImpl enterUser = new UserDaoImpl();
		User ansver = enterUser.selectUser(login, pass);
		return Response.ok(new GenericEntity<User>(ansver) {}).build()*/
		//return Response.status(401).build();

	}

}