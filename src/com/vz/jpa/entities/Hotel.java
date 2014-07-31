package com.vz.jpa.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by User on 24.07.2014.
 */
@XmlRootElement
@Entity
@Table (name = "hotel", schema = "travelagency")
public class Hotel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6808037754424901637L;
	private Integer hotelId;
    private String fullName;
    private String shortName;
    private String location;
    private String typeHotel;
    private Integer phone1;
    private Integer phone2;
    private Integer fax;
    private String eMail;
    private Integer stars;
    private Integer rating;
    private String typeOfHotelRoom;
    private String description;
    private Integer people;
    private Double price;
    private String img;
    private Country countryByCountryId;
    private City cityByCityId;
    private Service serviceByServiceId;
    private Collection<Tour> toursByHotelId;
    
    public Hotel(){
    	
    }
    

    @Id
    @Column(name = "Hotel_id", nullable = false, insertable = true, updatable = true)
    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "Full_name", nullable = true, insertable = true, updatable = true, length = 80)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "Short_name", nullable = true, insertable = true, updatable = true, length = 45)
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Basic
    @Column(name = "Location", nullable = true, insertable = true, updatable = true, length = 45)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "Type_hotel", nullable = true, insertable = true, updatable = true, length = 45)
    public String getTypeHotel() {
        return typeHotel;
    }

    public void setTypeHotel(String typeHotel) {
        this.typeHotel = typeHotel;
    }

    @Basic
    @Column(name = "Phone_1", nullable = true, insertable = true, updatable = true)
    public Integer getPhone1() {
        return phone1;
    }

    public void setPhone1(Integer phone1) {
        this.phone1 = phone1;
    }

    @Basic
    @Column(name = "Phone_2", nullable = true, insertable = true, updatable = true)
    public Integer getPhone2() {
        return phone2;
    }

    public void setPhone2(Integer phone2) {
        this.phone2 = phone2;
    }

    @Basic
    @Column(name = "FAX", nullable = true, insertable = true, updatable = true)
    public Integer getFax() {
        return fax;
    }

    public void setFax(Integer fax) {
        this.fax = fax;
    }

    @Basic
    @Column(name = "E_mail", nullable = true, insertable = true, updatable = true, length = 45)
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Basic
    @Column(name = "Stars", nullable = true, insertable = true, updatable = true)
    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    @Basic
    @Column(name = "Rating", nullable = true, insertable = true, updatable = true)
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "Type_of_hotel_room", nullable = true, insertable = true, updatable = true, length = 45)
    public String getTypeOfHotelRoom() {
        return typeOfHotelRoom;
    }

    public void setTypeOfHotelRoom(String typeOfHotelRoom) {
        this.typeOfHotelRoom = typeOfHotelRoom;
    }

    @Basic
    @Column(name = "Description", nullable = true, insertable = true, updatable = true, length = 45)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "People", nullable = true, insertable = true, updatable = true)
    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
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
    @Column(name = "Img", nullable = true, insertable = true, updatable = true, length = 45)
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;

        if (hotelId != hotel.hotelId) return false;
        if (description != null ? !description.equals(hotel.description) : hotel.description != null) return false;
        if (eMail != null ? !eMail.equals(hotel.eMail) : hotel.eMail != null) return false;
        if (fax != null ? !fax.equals(hotel.fax) : hotel.fax != null) return false;
        if (fullName != null ? !fullName.equals(hotel.fullName) : hotel.fullName != null) return false;
        if (img != null ? !img.equals(hotel.img) : hotel.img != null) return false;
        if (location != null ? !location.equals(hotel.location) : hotel.location != null) return false;
        if (people != null ? !people.equals(hotel.people) : hotel.people != null) return false;
        if (phone1 != null ? !phone1.equals(hotel.phone1) : hotel.phone1 != null) return false;
        if (phone2 != null ? !phone2.equals(hotel.phone2) : hotel.phone2 != null) return false;
        if (price != null ? !price.equals(hotel.price) : hotel.price != null) return false;
        if (rating != null ? !rating.equals(hotel.rating) : hotel.rating != null) return false;
        if (shortName != null ? !shortName.equals(hotel.shortName) : hotel.shortName != null) return false;
        if (stars != null ? !stars.equals(hotel.stars) : hotel.stars != null) return false;
        if (typeHotel != null ? !typeHotel.equals(hotel.typeHotel) : hotel.typeHotel != null) return false;
        if (typeOfHotelRoom != null ? !typeOfHotelRoom.equals(hotel.typeOfHotelRoom) : hotel.typeOfHotelRoom != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hotelId;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (typeHotel != null ? typeHotel.hashCode() : 0);
        result = 31 * result + (phone1 != null ? phone1.hashCode() : 0);
        result = 31 * result + (phone2 != null ? phone2.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (stars != null ? stars.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (typeOfHotelRoom != null ? typeOfHotelRoom.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (people != null ? people.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (img != null ? img.hashCode() : 0);
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

    @ManyToOne
    @JoinColumn(name = "City_id", referencedColumnName = "City_id")
    public City getCityByCityId() {
        return cityByCityId;
    }

    public void setCityByCityId(City cityByCityId) {
        this.cityByCityId = cityByCityId;
    }

    @ManyToOne
    @JoinColumn(name = "Service_id", referencedColumnName = "Service_id")
    public Service getServiceByServiceId() {
        return serviceByServiceId;
    }

    public void setServiceByServiceId(Service serviceByServiceId) {
        this.serviceByServiceId = serviceByServiceId;
    }

    @OneToMany(mappedBy = "hotelByHotelId")
    public Collection<Tour> getToursByHotelId() {
        return toursByHotelId;
    }

    public void setToursByHotelId(Collection<Tour> toursByHotelId) {
        this.toursByHotelId = toursByHotelId;
    }
}
