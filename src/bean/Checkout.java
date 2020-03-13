/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Haraj
 */
@Entity
public class Checkout implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    @OneToOne
    private Appointement nextAppointement;
    @OneToOne
    private Appointement currentAppointement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Appointement getNextAppointement() {
        return nextAppointement;
    }

    public void setNextAppointement(Appointement nextAppointement) {
        this.nextAppointement = nextAppointement;
    }

    public Appointement getCurrentAppointement() {
        return currentAppointement;
    }

    public void setCurrentAppointement(Appointement currentAppointement) {
        this.currentAppointement = currentAppointement;
    }

    public Checkout(String reference, Appointement nextAppointement, Appointement currentAppointement) {
        this.reference = reference;
        this.nextAppointement = nextAppointement;
        this.currentAppointement = currentAppointement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Checkout)) {
            return false;
        }
        Checkout other = (Checkout) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
}
