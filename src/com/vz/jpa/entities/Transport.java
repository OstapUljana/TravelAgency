package com.vz.jpa.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by User on 24.07.2014.
 */
@XmlRootElement
@Entity
public class Transport {
    private int transportId;
    private String transport;
    private Timestamp timeArrive;
    private Timestamp timeShip;
    private Double price;
    private Collection<Tour> toursByTransportId;
    private City cityByShipmentCity;
    private City cityByArriveCity;
    private Country countryByShipmentCountry;
    private Country countryByArriveCountry;

    @Id
    @Column(name = "Transport_id", nullable = false, insertable = true, updatable = true)
    public int getTransportId() {
        return transportId;
    }

    public void setTransportId(int transportId) {
        this.transportId = transportId;
    }

    @Basic
    @Column(name = "Transport", nullable = true, insertable = true, updatable = true, length = 45)
    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    @Basic
    @Column(name = "Time_arrive", nullable = true, insertable = true, updatable = true)
    public Timestamp getTimeArrive() {
        return timeArrive;
    }

    public void setTimeArrive(Timestamp timeArrive) {
        this.timeArrive = timeArrive;
    }

    @Basic
    @Column(name = "Time_ship", nullable = true, insertable = true, updatable = true)
    public Timestamp getTimeShip() {
        return timeShip;
    }

    public void setTimeShip(Timestamp timeShip) {
        this.timeShip = timeShip;
    }

    @Basic
    @Column(name = "Price", nullable = true, insertable = true, updatable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transport transport1 = (Transport) o;

        if (transportId != transport1.transportId) return false;
        if (price != null ? !price.equals(transport1.price) : transport1.price != null) return false;
        if (timeArrive != null ? !timeArrive.equals(transport1.timeArrive) : transport1.timeArrive != null)
            return false;
        if (timeShip != null ? !timeShip.equals(transport1.timeShip) : transport1.timeShip != null) return false;
        if (transport != null ? !transport.equals(transport1.transport) : transport1.transport != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = transportId;
        result = 31 * result + (transport != null ? transport.hashCode() : 0);
        result = 31 * result + (timeArrive != null ? timeArrive.hashCode() : 0);
        result = 31 * result + (timeShip != null ? timeShip.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "transportByTransportId")
    public Collection<Tour> getToursByTransportId() {
        return toursByTransportId;
    }

    public void setToursByTransportId(Collection<Tour> toursByTransportId) {
        this.toursByTransportId = toursByTransportId;
    }

    @ManyToOne
    @JoinColumn(name = "Shipment_city", referencedColumnName = "City_id")
    public City getCityByShipmentCity() {
        return cityByShipmentCity;
    }

    public void setCityByShipmentCity(City cityByShipmentCity) {
        this.cityByShipmentCity = cityByShipmentCity;
    }

    @ManyToOne
    @JoinColumn(name = "Arrive_city", referencedColumnName = "City_id")
    public City getCityByArriveCity() {
        return cityByArriveCity;
    }

    public void setCityByArriveCity(City cityByArriveCity) {
        this.cityByArriveCity = cityByArriveCity;
    }

    @ManyToOne
    @JoinColumn(name = "Shipment_country", referencedColumnName = "Country_id")
    public Country getCountryByShipmentCountry() {
        return countryByShipmentCountry;
    }

    public void setCountryByShipmentCountry(Country countryByShipmentCountry) {
        this.countryByShipmentCountry = countryByShipmentCountry;
    }

    @ManyToOne
    @JoinColumn(name = "Arrive_Country", referencedColumnName = "Country_id")
    public Country getCountryByArriveCountry() {
        return countryByArriveCountry;
    }

    public void setCountryByArriveCountry(Country countryByArriveCountry) {
        this.countryByArriveCountry = countryByArriveCountry;
    }
}
