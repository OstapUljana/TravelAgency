/*package com.vz.jpa.facade;

import java.text.ParseException;

import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


import com.vz.jpa.dao.ClientDaoImpl;
import com.vz.jpa.entities.Client;

@Path("")
public class ChangePassword {
	@POST()
	// @Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	static public String UpdateClient(
				@FormParam("e_mail") String email,
				@FormParam("password") String password,
				@FormParam("password") String password2,
			@HeaderParam("accept-charset") String headerParam) throws ParseException{
		ClientDaoImpl enterClient = new ClientDaoImpl();
		
		Client client = new Client(email, password);
		enterClient.update(client);
		return (Response.ok().entity(client).build().getEntity().toString());
		
		UserDaoImpl enterUser = new UserDaoImpl();
		User ansver = enterUser.selectUser(login, pass);
		return Response.ok(new GenericEntity<User>(ansver) {}).build();
		//return Response.status(401).build();

	}

}
*/