package com.vz.jpa.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by User on 24.07.2014.
 */
@Entity
public class Administrator {
    private int administratorId;
    private String name;
    private String surname;
    private String eMail;
    private String password;
    private Collection<Booking> bookingsByAdministratorId;

    @Id
    @Column(name = "Administrator_id", nullable = false, insertable = true, updatable = true)
    public int getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(int administratorId) {
        this.administratorId = administratorId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Administrator that = (Administrator) o;

        if (administratorId != that.administratorId) return false;
        if (eMail != null ? !eMail.equals(that.eMail) : that.eMail != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = administratorId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "administratorByAdministratorId")
    public Collection<Booking> getBookingsByAdministratorId() {
        return bookingsByAdministratorId;
    }

    public void setBookingsByAdministratorId(Collection<Booking> bookingsByAdministratorId) {
        this.bookingsByAdministratorId = bookingsByAdministratorId;
    }
}
