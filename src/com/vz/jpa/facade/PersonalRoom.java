/*package com.vz.jpa.facade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.vz.jpa.dao.CityDaoImpl;
import com.vz.jpa.dao.ClientDaoImpl;
import com.vz.jpa.dao.CountryDaoImpl;
import com.vz.jpa.entities.City;
import com.vz.jpa.entities.Client;
import com.vz.jpa.entities.Country;

@Path("")
public class PersonalRoom  {

	@POST()
	// @Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	static public String UpdateClient(@FormParam("name") String name, 
				@FormParam("surname") String surname,
				@FormParam("birthday") String birthday,
				@FormParam("sex") String sex,
				@FormParam("phone") String phone, 
				@FormParam("city_id") int city_id,
				@FormParam("e_mail") String email,
				@FormParam("password") String password,
				@FormParam("passport") String passport, 
				@FormParam("country_id") int country_id,
				@FormParam("inn") int inn, 
				@FormParam("visa") String visa, 
			@HeaderParam("accept-charset") String headerParam) throws ParseException{
		ClientDaoImpl enterClient = new ClientDaoImpl();
		
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");//dd.mm.yyyy
		Date sbirthday = format.parse(birthday);
		 
		CityDaoImpl enterCity = new CityDaoImpl();
		CountryDaoImpl enterCountry = new CountryDaoImpl();	
		
		Client client = new Client(name, surname, sbirthday, sex, phone, enterCity.selectById(city_id),email,
				password, passport, enterCountry.selectById(country_id), inn, visa);
		enterClient.update(client);
		return (Response.ok().entity(client).build().getEntity().toString());
		
		UserDaoImpl enterUser = new UserDaoImpl();
		User ansver = enterUser.selectUser(login, pass);
		return Response.ok(new GenericEntity<User>(ansver) {}).build();
		//return Response.status(401).build();

	}
}
*/