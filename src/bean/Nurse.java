/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Haraj
 */
@Entity
public class Nurse extends Personne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Service service;
    private Doctor doctor;
    @OneToMany(mappedBy = "nurse")
    private List<PatientFile> patientsFile;
    @OneToMany(mappedBy = "nurse")
    private List<Consultation> consultations;
    @OneToMany(mappedBy = "nurse")
    private List<RendezVous> rendezVous;
    private List<Date> workDays;

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

    public List<PatientFile> getPatientsFile() {
        return patientsFile;
    }

    public void setPatientsFile(List<PatientFile> patientsFile) {
        this.patientsFile = patientsFile;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    public List<Date> getWorkDays() {
        return workDays;
    }

    public void setWorkDays(List<Date> workDays) {
        this.workDays = workDays;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<RendezVous> getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(List<RendezVous> rendezVous) {
        this.rendezVous = rendezVous;
    }

    public Nurse(Service service, Doctor doctor, String CNI, String lastName, String FirstName, String sexe, String mail, int phoneNumber, String country, String city, String address, String password) {
        super(CNI, lastName, FirstName, sexe, mail, phoneNumber, country, city, address, password);
        this.service = service;
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
        if (!(object instanceof Nurse)) {
            return false;
        }
        Nurse other = (Nurse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}