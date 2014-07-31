package com.vz.jpa.facade;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/logout")
public class LogOutClass {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	static public Response logOutByDeleteCookies() {
		return Response
				.ok()
				.cookie(new NewCookie("client id", null),
						new NewCookie("client name", null),
						new NewCookie("role", null)).build();
	}
}
