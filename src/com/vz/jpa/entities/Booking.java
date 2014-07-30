package com.vz.jpa.entities;

import javax.persistence.*;

/**
 * Created by User on 24.07.2014.
 */
@Entity
public class Booking {
    private int bookingId;
    private String status;
    private Client clientByClientId;
    private Tour tourByTourId;
    private Administrator administratorByAdministratorId;

    @Id
    @Column(name = "Booking_id", nullable = false, insertable = true, updatable = true)
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    @Basic
    @Column(name = "Status", nullable = true, insertable = true, updatable = true, length = 30)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        if (bookingId != booking.bookingId) return false;
        if (status != null ? !status.equals(booking.status) : booking.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookingId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Client_id", referencedColumnName = "Client_id")
    public Client getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(Client clientByClientId) {
        this.clientByClientId = clientByClientId;
    }

    @ManyToOne
    @JoinColumn(name = "Tour_id", referencedColumnName = "Tour_id")
    public Tour getTourByTourId() {
        return tourByTourId;
    }

    public void setTourByTourId(Tour tourByTourId) {
        this.tourByTourId = tourByTourId;
    }

    @ManyToOne
    @JoinColumn(name = "Administrator_id", referencedColumnName = "Administrator_id")
    public Administrator getAdministratorByAdministratorId() {
        return administratorByAdministratorId;
    }

    public void setAdministratorByAdministratorId(Administrator administratorByAdministratorId) {
        this.administratorByAdministratorId = administratorByAdministratorId;
    }
}
