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
    private Service service;
    private List<Doctor> doctors;
    private List<PatientFile> patientsFile;
    private List<Consultation> consultations;
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

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Date> getWorkDays() {
        return workDays;
    }

    public void setWorkDays(List<Date> workDays) {
        this.workDays = workDays;
    }

    public Nurse(Long id, Service service, List<Doctor> doctors, List<PatientFile> patientsFile, List<Consultation> consultations, List<Date> workDays) {
        this.id = id;
        this.service = service;
        this.doctors = doctors;
        this.patientsFile = patientsFile;
        this.consultations = consultations;
        this.workDays = workDays;
    }

    

    public Nurse() {
        super();
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

    @Override
    public String toString() {
        return "gestionrendezvous.bean.Infermier[ id=" + id + " ]";
    }
    
}
