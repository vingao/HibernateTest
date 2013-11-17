package org.example.entities;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by a202898 on 11/16/13.
 */
@Entity
@Table(name = "EMAIL", schema = "CIWS", catalog = "")
public class EntityEmail {
    private BigDecimal id;
    private String email;
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
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityEmail that = (EntityEmail) o;

        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
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
