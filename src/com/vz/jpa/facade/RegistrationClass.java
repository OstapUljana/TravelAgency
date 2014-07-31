package com.vz.jpa.facade;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.vz.jpa.entities.*;
import com.vz.jpa.dao.*;

@Path("/reg")
public class RegistrationClass {

	/*
	 * @POST() //@Consumes(MediaType.APPLICATION_JSON)
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) //@Produces("text/plain") public
	 * Response registrationClientForm(@FormParam("first_name") String name,
	 * 
	 * @FormParam("last_name") String surname,
	 * 
	 * @FormParam("email") String email,
	 * 
	 * @FormParam("password") String password,
	 * 
	 * @FormParam("password_confirmation") String password_config) {
	 * 
	 * ClientDaoImpl enterClient = new ClientDaoImpl(); if (
	 * enterClient.selectByEmail(email) == false ) { Client client = new Client
	 * (); return (Response.ok().entity(client).build()); } else { Client client
	 * = new Client(name, surname, email, password); client =
	 * enterClient.insert(client); return
	 * (Response.ok().entity(client).build().getEntity().toString()); } }
	 */
	@POST()
	// @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	// @Produces("text/plain")
	public Response registrationClientForm(
			@FormParam("first_name") String name,
			@FormParam("last_name") String surname,
			@FormParam("email") String email,
			@FormParam("password") String password) throws URISyntaxException {
		// @FormParam("password_confirmation") String password_config) {

		ClientDaoImpl enterClient = new ClientDaoImpl();
		if (!enterClient.selectByEmail(email)) {
			Client client = new Client(name, surname, email, password);
			client = enterClient.insert(client);
			MailSending mail = new MailSending();
			mail.sendPassword("ostapulja@gmail.com", "hello");

			URI urlResponse = new URI(
					"http://localhost:8080/TravelAgency/login.html");
			return Response.seeOther(urlResponse).entity(client).build();

		} else {
			return Response.ok().entity("Client exist").build();
		}
	}

}