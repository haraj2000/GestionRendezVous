/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Consultation;
import bean.Doctor;
import bean.PatientFile;
import java.util.Date;
import bean.Nurse;
import bean.Patient;

/**
 *
 * @author Haraj
 */
public class ConsultationService extends AbstractFacade<Consultation> {
    
      public ConsultationService() {
        super(Consultation.class);
    }
      
       public Consultation createConsultation(String reference, Doctor doctor,Nurse nurse,Patient patient, PatientFile patientFile){
         Consultation consultationFounded = find(reference);
         if(consultationFounded== null){
         consultationFounded= new Consultation(reference, doctor,nurse,patient, patientFile);
             create(consultationFounded);
             nurse.getConsultations().add(consultationFounded);
             doctor.getConsultations().add(consultationFounded);
             patient.getConsultations().add(consultationFounded);
             patientFile.getConsultations().add(consultationFounded);
         }
             return consultationFounded;
     }
    
}

