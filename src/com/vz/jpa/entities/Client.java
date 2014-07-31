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
@Table (name = "client", schema = "travelagency")
public class Client {
    private int clientId;
    private String name;
    private String surname;
    private Date birthday;
    private String sex;
    private String phone;
    private String eMail;
    private String password;
    private String passport;
    private Integer inn;
    private String visa;
    private String comment;
    private Collection<Booking> bookingsByClientId;
    private Country countryByCountryId;
    private City cityByCityId;
    
    public Client(){
    	
    }
    
    public Client(String name, String surname, String email, String password){
    	this.name = name;
    	this.surname = surname;
    	this.eMail = email;
    	this.password = password;
    }

    public Client(String name2, String surname2, Date birthday2,
			String sex2, String phone2, City city_id, String email2,
			String password2, String passport2, Country country_id, int inn2,
			String visa2) {
    	this.name = name2;
    	this.surname = surname2;
    	this.birthday = birthday2;
    	this.sex = sex2;
    	this.phone = phone2;
    	this.cityByCityId = city_id;
    	this.passport = passport2;
    	this.password = password2;
    	this.inn = inn2;
    	this.visa = visa2;   	
    	this.eMail = email2;
    	this.password = password2;
	}


	public Client(String email2, String password2) {
		this.eMail = email2;
		this.password  = password2;
	}
	
	

	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name = "Client_id", nullable = false, insertable = true, updatable = true)
	 public Integer getClientId() {
	  return clientId;
	 }
	
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "Name", nullable = true, insertable = true, updatable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Surname", nullable = true, insertable = true, updatable = true, length = 45)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "Birthday", nullable = true, insertable = true, updatable = true)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "Sex", nullable = true, insertable = true, updatable = true, length = 1)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "Phone", nullable = true, insertable = true, updatable = true, length = 45)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    @Column(name = "Password", nullable = true, insertable = true, updatable = true, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "Passport", nullable = true, insertable = true, updatable = true, length = 45)
    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Basic
    @Column(name = "INN", nullable = true, insertable = true, updatable = true)
    public Integer getInn() {
        return inn;
    }

    public void setInn(Integer inn) {
        this.inn = inn;
    }

    @Basic
    @Column(name = "Visa", nullable = true, insertable = true, updatable = true, length = 45)
    public String getVisa() {
        return visa;
    }

    public void setVisa(String visa) {
        this.visa = visa;
    }

    @Basic
    @Column(name = "Comment", nullable = true, insertable = true, updatable = true, length = 255)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (clientId != client.clientId) return false;
        if (birthday != null ? !birthday.equals(client.birthday) : client.birthday != null) return false;
        if (comment != null ? !comment.equals(client.comment) : client.comment != null) return false;
        if (eMail != null ? !eMail.equals(client.eMail) : client.eMail != null) return false;
        if (inn != null ? !inn.equals(client.inn) : client.inn != null) return false;
        if (name != null ? !name.equals(client.name) : client.name != null) return false;
        if (passport != null ? !passport.equals(client.passport) : client.passport != null) return false;
        if (password != null ? !password.equals(client.password) : client.password != null) return false;
        if (phone != null ? !phone.equals(client.phone) : client.phone != null) return false;
        if (sex != null ? !sex.equals(client.sex) : client.sex != null) return false;
        if (surname != null ? !surname.equals(client.surname) : client.surname != null) return false;
        if (visa != null ? !visa.equals(client.visa) : client.visa != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        result = 31 * result + (inn != null ? inn.hashCode() : 0);
        result = 31 * result + (visa != null ? visa.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "clientByClientId")
	 public Collection<Booking> getBookingsByClientId() {
	  return bookingsByClientId;
	 }

    public void setBookingsByClientId(Collection<Booking> bookingsByClientId) {
        this.bookingsByClientId = bookingsByClientId;
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
}
