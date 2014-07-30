package com.vz.jpa.facade;

import java.util.List;

import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import com.vz.jpa.dao.*;
import com.vz.jpa.entities.*;

@Path("/login")
public class AutorisationClass {

 @POST()
 // @Consumes(MediaType.APPLICATION_JSON)
 @Produces(MediaType.APPLICATION_JSON)
  //@Produces("text/plain")
 static public Response chekUser(
		 @FormParam("login") String login,
		 @FormParam("password") String pass,
		 @CookieParam("client id") String cookie) {
	 ClientDaoImpl enterClient = new ClientDaoImpl();
	 if(enterClient.clientExistCheck(login, pass)){
		 Client ansver = enterClient.selectByEmailandPassword(login, pass);
		 return Response.ok(ansver).cookie(new NewCookie("clien_ id", (ansver.getClientId()).toString()) ).build();
	 }
	 else{
		 return Response.ok().status(406).build();
	 }
 }
}
/*package com.vz.jpa.facade;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.vz.jpa.dao.*;
import com.vz.jpa.entities.*;

@Path("/login")
public class AutorisationClass {

	@POST()
	// @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces("text/plain")
	static public Response chekUser(@FormParam("login") String login,
			@FormParam("password") String pass, 
			@HeaderParam("accept-charset") String headerParam) {
		ClientDaoImpl enterClient = new ClientDaoImpl();
		Client ansver = enterClient.selectByEmailandPassword(login, pass);
		return (Response.ok().entity(ansver).build().getEntity().toString());
		
		UserDaoImpl enterUser = new UserDaoImpl();
		User ansver = enterUser.selectUser(login, pass);
		return Response.ok(new GenericEntity<User>(ansver) {}).build();
		//return Response.status(401).build();

	}

}
*/