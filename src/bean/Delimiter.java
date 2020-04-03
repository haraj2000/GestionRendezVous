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
import javax.persistence.Temporal;
import java.util.Date;
import javax.persistence.OneToOne;

/**
 *
 * @author blackswan
 */
@Entity
public class Delimiter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dayStopWork;
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date HourStopWork;
    @Temporal(javax.persistence.TemporalType.DATE)
     private Date dayStartWork;
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date HourStartWork;
    @OneToOne
    private Doctor doctor;

    

    public Date getHourStopWork() {
        return HourStopWork;
    }

    public void setHourStopWork(Date HourStopWork) {
        this.HourStopWork = HourStopWork;
    }

    public Date getDayStopWork() {
        return dayStopWork;
    }

    public void setDayStopWork(Date dayStopWork) {
        this.dayStopWork = dayStopWork;
    }

    public Date getDayStartWork() {
        return dayStartWork;
    }

    public void setDayStartWork(Date dayStartWork) {
        this.dayStartWork = dayStartWork;
    }

    

    public Date getHourStartWork() {
        return HourStartWork;
    }

    public void setHourStartWork(Date HourStartWork) {
        this.HourStartWork = HourStartWork;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Delimiter(Long id, Date dayStopWork, Date HourStopWork, Date dayStartWork, Date HourStartWork, Doctor doctor) {
        this.id = id;
        this.dayStopWork = dayStopWork;
        this.HourStopWork = HourStopWork;
        this.dayStartWork = dayStartWork;
        this.HourStartWork = HourStartWork;
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
        if (!(object instanceof Delimiter)) {
            return false;
        }
        Delimiter other = (Delimiter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Delimiter[ id=" + id + " ]";
    }
    
}
