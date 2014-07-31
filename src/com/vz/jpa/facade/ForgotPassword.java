package com.vz.jpa.facade;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.vz.jpa.dao.ClientDaoImpl;


@Path("/forgot")
public class ForgotPassword {
@POST()
// @Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
// @Produces("text/plain")
public void forgotPassword(@FormParam("email") String email){
	ClientDaoImpl client = new ClientDaoImpl();
	String st = client.selectByEmailClient(email).getPassword();
	MailSending mail = new MailSending();	
    mail.sendPassword(email, st);
}
}
