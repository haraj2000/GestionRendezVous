/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Doctor;
import bean.Patient;
import bean.RendezVous;
import bean.Service;
import java.util.Date;

/**
 *
 * @author Haraj
 */
public class RendezVousService extends AbstractFacade<RendezVous>{

    public RendezVousService() {
        super(RendezVous.class);
    }
    
    
     public RendezVous createRendezVous(String reference, Date date, Date hour, Patient patient, Doctor doctor, Service service){
         RendezVous rendezVousFounded = find(reference);
         if(rendezVousFounded == null){
             rendezVousFounded = new RendezVous(reference, date, hour, patient, doctor, service);
             create(rendezVousFounded);
             doctor.getRendezVous().add(rendezVousFounded);
             patient.getRendezVouses().add(rendezVousFounded);
         }
             return rendezVousFounded;
     }
     
     public int removeRendezVous(String reference){
         RendezVous rendezVousFounded = find(reference);
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
     
     public RendezVous editRendezVous(String reference, Date date, Date hour, Patient patient, Doctor doctor, Service service)
     {
         RendezVous rendezVousFounded = find(reference);
         if( rendezVousFounded != null){
             rendezVousFounded.setDate(date);
             rendezVousFounded.setHour(hour);
         
         edit(rendezVousFounded);
         }
             return rendezVousFounded;
     } 
}
