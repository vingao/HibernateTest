package org.example.entities;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by a202898 on 11/16/13.
 */
@Entity
@Table(name = "PHONE", schema = "CIWS", catalog = "")
public class EntityPhone {
    private BigDecimal id;
    private String phoneNumber;
    private EntityPerson personByPersonId;

    @Id
    @Column(name = "ID")
    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PHONE_NUMBER")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityPhone that = (EntityPhone) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "ID")
    public EntityPerson getPersonByPersonId() {
        return personByPersonId;
    }

    public void setPersonByPersonId(EntityPerson personByPersonId) {
        this.personByPersonId = personByPersonId;
    }
}
