package org.example.entities;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by a202898 on 11/16/13.
 */
@Entity
@Table(name = "PERSON", schema = "CIWS", catalog = "")
public class EntityPerson {
    private BigDecimal id;
    private String completeName;
    private Timestamp birthDate;
    private String placeOfBirth;
    private Collection<EntityEmail> emailsById;
    private Collection<EntityPhone> phonesById;

    @Id
    @Column(name = "ID")
    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    @Basic
    @Column(name = "COMPLETE_NAME")
    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    @Basic
    @Column(name = "BIRTH_DATE")
    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "PLACE_OF_BIRTH")
    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityPerson that = (EntityPerson) o;

        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (completeName != null ? !completeName.equals(that.completeName) : that.completeName != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (placeOfBirth != null ? !placeOfBirth.equals(that.placeOfBirth) : that.placeOfBirth != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (completeName != null ? completeName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (placeOfBirth != null ? placeOfBirth.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "personByPersonId")
    //@Fetch(FetchMode.JOIN)
    public Collection<EntityEmail> getEmailsById() {
        return emailsById;
    }

    public void setEmailsById(Collection<EntityEmail> emailsById) {
        this.emailsById = emailsById;
    }

    @OneToMany(mappedBy = "personByPersonId")
    public Collection<EntityPhone> getPhonesById() {
        return phonesById;
    }

    public void setPhonesById(Collection<EntityPhone> phonesById) {
        this.phonesById = phonesById;
    }
    
}
