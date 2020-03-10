/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Checkout;
import bean.Consultation;
import bean.Doctor;
import bean.PatientFile;
import bean.Prescription;
import java.util.Date;

/**
 *
 * @author Haraj
 */
public class ConsultationService extends AbstractFacade<Consultation> {
    
      public ConsultationService() {
        super(Consultation.class);
    }
      
       public Consultation createConsultation(String reference,Date date, Date timeStart, Doctor doctor, PatientFile patientFile){
         Consultation consultationFounded = find(reference);
         if(consultationFounded== null){
         consultationFounded= new Consultation(reference, date, timeStart, doctor, patientFile);
             create(consultationFounded);
         }
             return consultationFounded;
     }
       
         
 
     
     public Consultation editConsultation(String reference,Date date, Date timeStart, Doctor doctor, PatientFile patientFile)
     {
         Consultation consultationFounded= find(reference);
         if( consultationFounded== null)
         {
             consultationFounded= new Consultation(reference, date, timeStart, doctor, patientFile);
             create(consultationFounded);
         }
         else edit(consultationFounded);
             return consultationFounded;
     }
    
}

