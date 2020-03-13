/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Doctor;
import bean.Patient;
import bean.Appointement;
import static bean.Appointement_.typeAppointement;
import bean.Service;
import bean.TypeAppointement;
import java.util.Date;

/**
 *
 * @author Haraj
 */
public class RendezVousService extends AbstractFacade<Appointement>{

    public RendezVousService() {
        super(Appointement.class);
    }
    
    
     public Appointement createRendezVous(String reference, Date date, Date hour, Patient patient, Doctor doctor, TypeAppointement typeAppointement){
         Appointement rendezVousFounded = find(reference);
         if(rendezVousFounded == null){
             rendezVousFounded = new Appointement(reference, date, hour, typeAppointement, patient, doctor);
             create(rendezVousFounded);
             doctor.getRendezVous().add(rendezVousFounded);
             patient.getRendezVouses().add(rendezVousFounded);
         }
             return rendezVousFounded;
     }
     
     public int removeRendezVous(String reference){
         Appointement rendezVousFounded = find(reference);
         if( rendezVousFounded == null)
             return -1;
         else {
             Doctor doctor = rendezVousFounded.getDoctor();
             Patient patient = rendezVousFounded.getPatient();
             remove(rendezVousFounded);
             doctor.getRendezVous().remove(rendezVousFounded);
             patient.getRendezVouses().remove(rendezVousFounded);
             return 1;
         }
     }
     
     public Appointement editRendezVous(String reference, Date date, Date hour, Patient patient, Doctor doctor, Service service)
     {
         Appointement rendezVousFounded = find(reference);
         if( rendezVousFounded != null){
             rendezVousFounded.setDateAppointement(date);
             rendezVousFounded.setHourAppointement(hour);
         
         edit(rendezVousFounded);
         }
             return rendezVousFounded;
     } 
}
