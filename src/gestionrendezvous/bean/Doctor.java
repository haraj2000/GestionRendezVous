/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionrendezvous.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Haraj
 */
@Entity
public class Doctor extends Personne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Service service;
    private Date workDay;
    @ManyToOne
    private Nurse nurse;
    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;
    @OneToMany(mappedBy = "doctor")
    private List<RendezVous> rendezVouss;
     

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<RendezVous> getRendezVouss() {
        return rendezVouss;
    }

    public void setRendezVouss(List<RendezVous> rendezVouss) {
        this.rendezVouss = rendezVouss;
    }

    public Date getWorkDay() {
        return workDay;
    }

    public void setWorkDay(Date workDay) {
        this.workDay = workDay;
    }

    public Doctor( Service service, Date workDay, Nurse nurse, List<Patient> patients, List<RendezVous> rendezVouss, Long id, String CNI, String lastName, String FirstName, String sexe, String mail, int phoneNumber, String country, String city, String address, String password, List<RendezVous> rendezVous) {
        super(id, CNI, lastName, FirstName, sexe, mail, phoneNumber, country, city, address, password, rendezVous);
    
        this.service = service;
        this.workDay = workDay;
        this.nurse = nurse;
        this.patients = patients;
        this.rendezVouss = rendezVouss;
    }
    

   

    public Doctor() {
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
        if (!(object instanceof Doctor)) {
            return false;
        }
        Doctor other = (Doctor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Doctor{" + "id=" + id + ", service=" + service + ", workDay=" + workDay + ", nurse=" + nurse + ", patients=" + patients + ", rendezVouss=" + rendezVouss + '}';
    }

   
    

  
    
}
