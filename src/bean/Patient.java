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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

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
    private int age;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dayBirth;
    @OneToMany(mappedBy = "patient")
    private List<Consultation> consultations;
    @ManyToMany(mappedBy = "patient")
    private List<Doctor> doctors;
    @OneToMany(mappedBy = "patient")
    private List<RendezVous> rendezVouses;
    @OneToMany(mappedBy = "patient")
    private List<PatientFile> patientFiles;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDayBirth() {
        return dayBirth;
    }

    public void setDayBirth(Date dayBirth) {
        this.dayBirth = dayBirth;
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

    public List<RendezVous> getRendezVouses() {
        return rendezVouses;
    }

    public void setRendezVouses(List<RendezVous> rendezVouses) {
        this.rendezVouses = rendezVouses;
    }

    public List<PatientFile> getPatientFiles() {
        return patientFiles;
    }

    public void setPatientFiles(List<PatientFile> patientFiles) {
        this.patientFiles = patientFiles;
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

    public Patient(int age, Date dayBirth, String CNI, String lastName, String FirstName, String sexe, String mail, int phoneNumber, String country, String city, String address, String password) {
        super(CNI, lastName, FirstName, sexe, mail, phoneNumber, address, password);
        this.age = age;
        this.dayBirth = dayBirth;
    }
    
}
