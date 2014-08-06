package com.vz.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Collection;

/**
 * Created by User on 24.07.2014.
 */
@XmlRootElement
@Entity
@Table(name = "country", schema = "travelagency")
public class Country {
	private Integer countryId;
	private String country;
	private String description;
	/*
	private Collection<City> citiesByCountryId;
	private Collection<Client> clientsByCountryId;
	private Collection<Hotel> hotelsByCountryId;
	private Collection<Tour> toursByCountryId;
	private Collection<Tour> toursByCountryId_0;
	private Collection<Transport> transportsByCountryId;
	private Collection<Transport> transportsByCountryId_0;
	*/

	public Country() {

	}

	public Country(Integer countryId, String country, String description  /*,
			Collection<City> citiesByCountryId,
			Collection<Client> clientsByCountryId,
			Collection<Hotel> hotelsByCountryId,
			Collection<Tour> toursByCountryId,
			Collection<Tour> toursByCountryId_0,
			Collection<Transport> transportsByCountryId,
			Collection<Transport> transportsByCountryId_0*/) {

		this.countryId = countryId;
		this.country = country;
		this.description = description;
		/*
		this.citiesByCountryId = citiesByCountryId;
		this.clientsByCountryId = clientsByCountryId;
		this.hotelsByCountryId = hotelsByCountryId;
		this.toursByCountryId = toursByCountryId;
		this.toursByCountryId_0 = toursByCountryId_0;
		this.transportsByCountryId = transportsByCountryId;
		this.transportsByCountryId_0 = transportsByCountryId_0;
		*/
	}

	@Id
	@Column(name = "Country_id", nullable = false, insertable = true, updatable = true)
	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	@Basic
	@Column(name = "Country", nullable = true, insertable = true, updatable = true, length = 45)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Basic
	@Column(name = "Description", nullable = true, insertable = true, updatable = true, length = 45)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Country country1 = (Country) o;

		if (countryId != country1.countryId)
			return false;
		if (country != null ? !country.equals(country1.country)
				: country1.country != null)
			return false;
		if (description != null ? !description.equals(country1.description)
				: country1.description != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = countryId;
		result = 31 * result + (country != null ? country.hashCode() : 0);
		result = 31 * result
				+ (description != null ? description.hashCode() : 0);
		return result;
	}

	/*
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "countryByCountryId")
	public Collection<City> getCitiesByCountryId() {
		return citiesByCountryId;
	}

	public void setCitiesByCountryId(Collection<City> citiesByCountryId) {
		this.citiesByCountryId = citiesByCountryId;
	}

	@OneToMany(mappedBy = "countryByCountryId")
	public Collection<Client> getClientsByCountryId() {
		return clientsByCountryId;
	}

	public void setClientsByCountryId(Collection<Client> clientsByCountryId) {
		this.clientsByCountryId = clientsByCountryId;
	}

	@OneToMany(mappedBy = "countryByCountryId")
	public Collection<Hotel> getHotelsByCountryId() {
		return hotelsByCountryId;
	}

	public void setHotelsByCountryId(Collection<Hotel> hotelsByCountryId) {
		this.hotelsByCountryId = hotelsByCountryId;
	}

	@OneToMany(mappedBy = "countryByStartCountry")
	public Collection<Tour> getToursByCountryId() {
		return toursByCountryId;
	}

	public void setToursByCountryId(Collection<Tour> toursByCountryId) {
		this.toursByCountryId = toursByCountryId;
	}

	@OneToMany(mappedBy = "countryByEndCountry")
	public Collection<Tour> getToursByCountryId_0() {
		return toursByCountryId_0;
	}

	public void setToursByCountryId_0(Collection<Tour> toursByCountryId_0) {
		this.toursByCountryId_0 = toursByCountryId_0;
	}

	@OneToMany(mappedBy = "countryByShipmentCountry")
	public Collection<Transport> getTransportsByCountryId() {
		return transportsByCountryId;
	}

	public void setTransportsByCountryId(
			Collection<Transport> transportsByCountryId) {
		this.transportsByCountryId = transportsByCountryId;
	}

	@OneToMany(mappedBy = "countryByArriveCountry")
	public Collection<Transport> getTransportsByCountryId_0() {
		return transportsByCountryId_0;
	}

	public void setTransportsByCountryId_0(
			Collection<Transport> transportsByCountryId_0) {
		this.transportsByCountryId_0 = transportsByCountryId_0;
	}
		@Basic
	@Column(name = "City_id", nullable = false, insertable = true, updatable = true)
	public Integer getCityByCityId() {
		return cityByCityId;
	}

	public void setCityByCityId(Integer cityByCityId) {
		this.cityByCityId = cityByCityId;
	}
	*/
}
