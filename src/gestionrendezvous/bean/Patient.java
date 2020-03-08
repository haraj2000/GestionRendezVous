/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionrendezvous.bean;

import java.io.Serializable;
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
public class Patient extends Personne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Service service;
    private int age;
    private List<Consultation> consultations;
    @OneToOne
    private PatientFile file;
    @ManyToOne
    private Doctor doctor;
    @OneToMany(mappedBy = "patient")
    private List<RendezVous> rendezVouses; 
    
    
    
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    public PatientFile getFile() {
        return file;
    }

    public void setFile(PatientFile file) {
        this.file = file;
        
    }

    public List<RendezVous> getRendezVouses() {
        return rendezVouses;
    }

    public void setRendezVouses(List<RendezVous> rendezVouses) {
        this.rendezVouses = rendezVouses;
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
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Patient(Long id, Service service, String FullName, Long phoneNumber, int age, List<Consultation> consultations, PatientFile file) {
        this.service = service;
        this.age = age;
        this.consultations = consultations;
        this.file = file;
        this.doctor=doctor;
    }

    public Patient() {
    }

    @Override
    public String toString() {
        return "Patient{" + "id=" + id + ", service=" + service + ", age=" + age + ", consultations=" + consultations + ", file=" + file + ", doctor=" + doctor + ", rendezVouses=" + rendezVouses + '}';
    }


    

  
    
   
    
}
