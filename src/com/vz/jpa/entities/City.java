package com.vz.jpa.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Collection;

/**
 * Created by User on 24.07.2014.
 */
@XmlRootElement
@Entity
public class City {
	private Integer cityId;
	private String name;
	private Country countryByCountryId;
	/*
	private Collection<Client> clientsByCityId;
	private Collection<Hotel> hotelsByCityId;
	private Collection<Tour> toursByCityId;
	private Collection<Tour> toursByCityId_0;
	private Collection<Transport> transportsByCityId;
	private Collection<Transport> transportsByCityId_0;
*/
	public City() {

	}

	public City(Integer cityId, String name, Country countryByCountryId /*,
			Collection<Client> clientsByCityId,
			Collection<Hotel> hotelsByCityId, Collection<Tour> toursByCityId,
			Collection<Tour> toursByCityId_0,
			Collection<Transport> transportsByCityId,
			Collection<Transport> transportsByCityId_0
			*/) {

		this.cityId = cityId;
		this.name = name;
		this.countryByCountryId = countryByCountryId;
		/*
		this.clientsByCityId = clientsByCityId;
		this.hotelsByCityId = hotelsByCityId;
		this.toursByCityId = toursByCityId;
		this.toursByCityId_0 = toursByCityId_0;
		this.transportsByCityId = transportsByCityId;
		this.transportsByCityId_0 = transportsByCityId_0;
		*/
	}

	@Id
	@Column(name = "City_id", nullable = false, insertable = true, updatable = true)
	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	@Basic
	@Column(name = "Name", nullable = true, insertable = true, updatable = true, length = 80)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		City city = (City) o;

		if (cityId != city.cityId)
			return false;
		if (name != null ? !name.equals(city.name) : city.name != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = cityId;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}

	@ManyToOne
	@JoinColumn(name = "Country_id", referencedColumnName = "Country_id")
	public Country getCountryByCountryId() {
		return countryByCountryId;
	}

	public void setCountryByCountryId(Country countryByCountryId) {
		this.countryByCountryId = countryByCountryId;
	}

	/*
	@OneToMany(fetch = FetchType.EAGER ,mappedBy = "cityByCityId")
	public Collection<Client> getClientsByCityId() {
		return clientsByCityId;
	}

	public void setClientsByCityId(Collection<Client> clientsByCityId) {
		this.clientsByCityId = clientsByCityId;
	}

	@OneToMany(mappedBy = "cityByCityId")
	public Collection<Hotel> getHotelsByCityId() {
		return hotelsByCityId;
	}

	public void setHotelsByCityId(Collection<Hotel> hotelsByCityId) {
		this.hotelsByCityId = hotelsByCityId;
	}

	@OneToMany(mappedBy = "cityByStartCity")
	public Collection<Tour> getToursByCityId() {
		return toursByCityId;
	}

	public void setToursByCityId(Collection<Tour> toursByCityId) {
		this.toursByCityId = toursByCityId;
	}

	@OneToMany(mappedBy = "cityByEndCity")
	public Collection<Tour> getToursByCityId_0() {
		return toursByCityId_0;
	}

	public void setToursByCityId_0(Collection<Tour> toursByCityId_0) {
		this.toursByCityId_0 = toursByCityId_0;
	}

	@OneToMany(mappedBy = "cityByShipmentCity")
	public Collection<Transport> getTransportsByCityId() {
		return transportsByCityId;
	}

	public void setTransportsByCityId(Collection<Transport> transportsByCityId) {
		this.transportsByCityId = transportsByCityId;
	}

	@OneToMany(mappedBy = "cityByArriveCity")
	public Collection<Transport> getTransportsByCityId_0() {
		return transportsByCityId_0;
	}

	public void setTransportsByCityId_0(
			Collection<Transport> transportsByCityId_0) {
		this.transportsByCityId_0 = transportsByCityId_0;
	}
	*/
}
