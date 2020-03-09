/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Doctor;
import bean.Nurse;
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
    
    
     public RendezVous createRendezVous(String reference, Date date, Date hour, String etat, Patient patient, Doctor doctor, Nurse nurse, Service service){
         RendezVous rendezVousFounded = find(reference);
         if(rendezVousFounded == null){
             rendezVousFounded = new RendezVous(reference, date, hour, etat, patient, doctor, nurse, service);
             create(rendezVousFounded);
         }
             return rendezVousFounded;
     }
     
     public int removeRendezVous(String reference){
         RendezVous rendezVousFounded = find(reference);
         if( rendezVousFounded == null)
             return -1;
         else {
             remove(rendezVousFounded);
             return 1;
         }
     }
     
     public RendezVous editrendezVous(String reference, Date date, Date hour, String etat, Patient patient, Doctor doctor, Nurse nurse, Service service)
     {
         RendezVous rendezVousFounded = find(reference);
         if( rendezVousFounded == null)
         {
             rendezVousFounded = new RendezVous(reference, date, hour, etat, patient, doctor, nurse, service);
             create(rendezVousFounded);
         }
         else edit(rendezVousFounded);
             return rendezVousFounded;
     } 
}
