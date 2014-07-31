package com.vz.jpa.facade;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
	// @Produces("text/plain")
	static public Response chekUser(@FormParam("login") String login,
			@FormParam("password") String pass,
			@CookieParam("client id") String cookie) throws URISyntaxException {
		{
			ClientDaoImpl enterClient = new ClientDaoImpl();
			System.out.println(cookie);
			if (enterClient.clientExistCheck(login, pass)) {
				Client ansver = enterClient.selectByEmailandPassword(login,
						pass);
				URI urlResponse = new URI("http://localhost:8080/TravelAgency");
				return Response
						.seeOther(urlResponse)
						.cookie(new NewCookie("client id",(ansver.getClientId()).toString(),"/","localhost"," ",-1,false),
								new NewCookie("client name", ansver.getName(),"/","localhost"," ",-1,false),
								new NewCookie("role", "user","/","localhost"," ",-1,false)).build();
			} else {
				return Response.ok().status(406).build();
			}
		}
	}
}
