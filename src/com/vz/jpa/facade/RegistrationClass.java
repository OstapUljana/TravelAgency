package com.vz.jpa.facade;


import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import java.util.Date;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.vz.jpa.entities.*;
import com.vz.jpa.dao.*;

@Path("/reg")
public class RegistrationClass {

	 /* @POST()
	  //@Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)
	  //@Produces("text/plain")
	  public Response registrationClientForm(@FormParam("first_name") String name, 
	  @FormParam("last_name") String surname,
	  @FormParam("email") String email, 
	  @FormParam("password") String password){
 
	 
		  ClientDaoImpl enterClient = new ClientDaoImpl();  
		  if ( enterClient.selectByEmail(email) == false ) {
			  return (Response.ok().status(406).build());
		  }	  
		  else {
			  Client client = new Client(name, surname, email, password);
			  client = enterClient.insert(client);
			  return (Response.ok(client).status(200).build().getEntity().toString());
		  }
	  }*/

	  @POST()
	  //@Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)
	  //@Produces("text/plain")
	  public Response registrationClientForm(@FormParam("first_name") String name, 
	  @FormParam("last_name") String surname,
	  @FormParam("email") String email, 
	  @FormParam("password") String password){
	  //@FormParam("password_confirmation") String password_config) {	 
	 
		  ClientDaoImpl enterClient = new ClientDaoImpl();  
		  if ( enterClient.selectByEmail(email) == false ) {
			  Client client = new Client ();
			  return (Response.ok().entity(client).build());
		  }	  
		  else {
			  Client client = new Client(name, surname, email, password);
			  enterClient.insert(client);
			  client = enterClient.selectByEmailandPassword(email, password);
			  return (Response.ok().entity(client).build()/*.getEntity().toString()*/);
		}
	}
}
