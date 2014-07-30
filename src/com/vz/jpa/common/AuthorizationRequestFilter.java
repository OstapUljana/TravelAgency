package com.vz.jpa.common;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.ContainerRequest;

import com.vz.jpa.entities.User;

@Provider
public class AuthorizationRequestFilter implements ContainerRequestFilter {
	public void filter(ContainerRequestContext requestContext)
			throws IOException {
	}

	public ContainerRequest filter(ContainerRequest containerRequest)
			throws WebApplicationException {
		// GET, POST, PUT, DELETE, ...
		String method = containerRequest.getMethod();
		// myresource/get/56bCA for example
		String path = containerRequest.getPath(true);

		// We do allow wadl to be retrieve
		if (method.equals("GET")
				&& (path.equals("application.wadl") || path
						.equals("application.wadl/xsd0.xsd"))) {
			return containerRequest;
		}

		// Get the authentification passed in HTTP headers parameters
		String auth = containerRequest.getHeaderString("authorization");

		// If the user does not have the right (does not provide any HTTP Basic
		// Auth)
		if (auth == null) {
			throw new WebApplicationException(Status.UNAUTHORIZED);
		}

		// lap : loginAndPassword
		String[] lap = BasicAuth.decode(auth);

		// If login or password fail
		if (lap == null || lap.length != 2) {
			throw new WebApplicationException(Status.UNAUTHORIZED);
		}

		// DO YOUR DATABASE CHECK HERE (replace that line behind)...

		// Our system refuse login and password


		// TODO : HERE YOU SHOULD ADD PARAMETER TO REQUEST, TO REMEMBER USER ON
		// YOUR REST SERVICE...

		return containerRequest;
	}
}
