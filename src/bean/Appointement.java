/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Haraj
 */
@Entity
public class Appointement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateAppointement;
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date hourAppointement;
    private String etatAppointement;
    @ManyToOne
    private TypeAppointement typeAppointement;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;



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

    public Date getDateAppointement() {
        return dateAppointement;
    }

    public void setDateAppointement(Date dateAppointement) {
        this.dateAppointement = dateAppointement;
    }

    public Date getHourAppointement() {
        return hourAppointement;
    }

    public void setHourAppointement(Date hourAppointement) {
        this.hourAppointement = hourAppointement;
    }

    public String getEtatAppointement() {
        return etatAppointement;
    }

    public void setEtatAppointement(String etatAppointement) {
        this.etatAppointement = etatAppointement;
    }

    public TypeAppointement getTypeAppointement() {
        return typeAppointement;
    }

    public void setTypeAppointement(TypeAppointement typeAppointement) {
        this.typeAppointement = typeAppointement;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Appointement(String reference, Date dateAppointement, Date hourAppointement, TypeAppointement typeAppointement, Patient patient, Doctor doctor) {
        this.reference = reference;
        this.dateAppointement = dateAppointement;
        this.hourAppointement = hourAppointement;
        this.typeAppointement = typeAppointement;
        this.patient = patient;
        this.doctor = doctor;
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
        if (!(object instanceof Appointement)) {
            return false;
        }
        Appointement other = (Appointement) object;
   
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
  
}
