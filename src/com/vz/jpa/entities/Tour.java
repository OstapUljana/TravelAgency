package com.vz.jpa.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;
import java.util.Collection;

/**
 * Created by User on 24.07.2014.
 */
@XmlRootElement
@Entity
@Table (name = "tour", schema = "travelagency")
public class Tour {
    private Integer tourId;
    private String tourName;
    private Integer tourLength;
 //   @Temporal (TemporalType.DATE)
    private Date startDate;
 //   @Temporal (TemporalType.DATE)
    private Date endDate;
    private Double price;
    private String description;
    private Integer hotTour;
    private Collection<Booking> bookingsByTourId;
    private Transport transportByTransportId;
    private Country countryByStartCountry;
    private City cityByStartCity;
    private Hotel hotelByHotelId;
    private Country countryByEndCountry;
    private City cityByEndCity;
    
    public Tour() {
		super();
	}

	public Tour(String tour_name, Integer tour_length, Date start_date,
			Date end_date, Double price2, String description2,
			Integer hot_tour, Transport selectById, Country selectById2,
			City selectById3, Hotel selectById4, Country selectById5,
			City selectById6) {
		this.tourName = tour_name;
		this.tourLength = tour_length;
		this.transportByTransportId = selectById;
		
		this.startDate = start_date;
		this.countryByStartCountry = selectById2;
		this.cityByStartCity = selectById3;
		
		this.endDate = end_date;
		this.countryByEndCountry = selectById5;
		this.cityByEndCity = selectById6;
		
		this.hotelByHotelId = selectById4;
		this.price = price2; 
		this.description = description2;
		this.hotTour = hot_tour;
	}



	public Tour(String tour_name, int tour_length, Transport selectById,
			Date start_date, Country selectById2, City selectById3,
			Date end_date, Country selectById4, City selectById5,
			Hotel selectById6, double price2, String description2, int hot_tour) {
		this.tourName = tour_name;
		this.tourLength = tour_length;
		this.transportByTransportId = selectById;
		
		this.startDate = start_date;
		this.countryByStartCountry = selectById2;
		this.cityByStartCity = selectById3;
		
		this.endDate = end_date;
		this.countryByEndCountry = selectById4;
		this.cityByEndCity = selectById5;
		
		this.hotelByHotelId = selectById6;
		this.price = price2; 
		this.description = description2;
		this.hotTour = hot_tour;
	}

	@Id
    @Column(name = "Tour_id", nullable = false, insertable = true, updatable = true)
    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    @Basic
    @Column(name = "Tour_name", nullable = true, insertable = true, updatable = true, length = 45)
    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    @Basic
    @Column(name = "Tour_length", nullable = true, insertable = true, updatable = true)
    public Integer getTourLength() {
        return tourLength;
    }

    public void setTourLength(Integer tourLength) {
        this.tourLength = tourLength;
    }

    @Basic
    @Temporal (TemporalType.DATE)
    @Column(name = "Start_date", nullable = true, insertable = true, updatable = true)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Temporal (TemporalType.DATE)
    @Column(name = "End_date", nullable = true, insertable = true, updatable = true)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "Price", nullable = true, insertable = true, updatable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "Description", nullable = true, insertable = true, updatable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Hot_tour", nullable = true, insertable = true, updatable = true)
    public Integer getHotTour() {
        return hotTour;
    }

    public void setHotTour(Integer hotTour) {
        this.hotTour = hotTour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tour tour = (Tour) o;

        if (tourId != tour.tourId) return false;
        if (description != null ? !description.equals(tour.description) : tour.description != null) return false;
        if (endDate != null ? !endDate.equals(tour.endDate) : tour.endDate != null) return false;
        if (hotTour != null ? !hotTour.equals(tour.hotTour) : tour.hotTour != null) return false;
        if (price != null ? !price.equals(tour.price) : tour.price != null) return false;
        if (startDate != null ? !startDate.equals(tour.startDate) : tour.startDate != null) return false;
        if (tourLength != null ? !tourLength.equals(tour.tourLength) : tour.tourLength != null) return false;
        if (tourName != null ? !tourName.equals(tour.tourName) : tour.tourName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tourId;
        result = 31 * result + (tourName != null ? tourName.hashCode() : 0);
        result = 31 * result + (tourLength != null ? tourLength.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (hotTour != null ? hotTour.hashCode() : 0);
        return result;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tourByTourId")
    public Collection<Booking> getBookingsByTourId() {
        return bookingsByTourId;
    }

    public void setBookingsByTourId(Collection<Booking> bookingsByTourId) {
        this.bookingsByTourId = bookingsByTourId;
    }

    @ManyToOne
    @JoinColumn(name = "Transport_id", referencedColumnName = "Transport_id")
    public Transport getTransportByTransportId() {
        return transportByTransportId;
    }

    public void setTransportByTransportId(Transport transportByTransportId) {
        this.transportByTransportId = transportByTransportId;
    }

    @ManyToOne
    @JoinColumn(name = "Start_Country", referencedColumnName = "Country_id")
    public Country getCountryByStartCountry() {
        return countryByStartCountry;
    }

    public void setCountryByStartCountry(Country countryByStartCountry) {
        this.countryByStartCountry = countryByStartCountry;
    }

    @ManyToOne
    @JoinColumn(name = "Start_City", referencedColumnName = "City_id")
    public City getCityByStartCity() {
        return cityByStartCity;
    }

    public void setCityByStartCity(City cityByStartCity) {
        this.cityByStartCity = cityByStartCity;
    }

    @ManyToOne
    @JoinColumn(name = "Hotel_id", referencedColumnName = "Hotel_id")
    public Hotel getHotelByHotelId() {
        return hotelByHotelId;
    }

    public void setHotelByHotelId(Hotel hotelByHotelId) {
        this.hotelByHotelId = hotelByHotelId;
    }

    @ManyToOne
    @JoinColumn(name = "End_Country", referencedColumnName = "Country_id")
    public Country getCountryByEndCountry() {
        return countryByEndCountry;
    }

    public void setCountryByEndCountry(Country countryByEndCountry) {
        this.countryByEndCountry = countryByEndCountry;
    }

    @ManyToOne
    @JoinColumn(name = "End_City", referencedColumnName = "City_id")
    public City getCityByEndCity() {
        return cityByEndCity;
    }

    public void setCityByEndCity(City cityByEndCity) {
        this.cityByEndCity = cityByEndCity;
    }
}
