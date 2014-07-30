package com.vz.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Created by User on 24.07.2014.
 */
@Entity
public class Service {
    private int serviceId;
    private Collection<Hotel> hotelsByServiceId;

    @Id
    @Column(name = "Service_id", nullable = false, insertable = true, updatable = true)
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Service service = (Service) o;

        if (serviceId != service.serviceId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return serviceId;
    }

    @OneToMany(mappedBy = "serviceByServiceId")
    public Collection<Hotel> getHotelsByServiceId() {
        return hotelsByServiceId;
    }

    public void setHotelsByServiceId(Collection<Hotel> hotelsByServiceId) {
        this.hotelsByServiceId = hotelsByServiceId;
    }
}
