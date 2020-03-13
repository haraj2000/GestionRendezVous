/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Consultation;
import bean.Doctor;
import bean.PatientFile;
import bean.Nurse;
import bean.Patient;
import bean.Appointement;
import java.util.Date;

/**
 *
 * @author Haraj
 */
public class ConsultationService extends AbstractFacade<Consultation> {
    
      public ConsultationService() {
        super(Consultation.class);
    }
      
       public Consultation createConsultation(String reference, Doctor doctor, Nurse nurse, Patient patient, PatientFile patientFile, Appointement rendezVous){
         Consultation consultationFounded = find(reference);
         if(consultationFounded== null){
         consultationFounded= new Consultation(reference, doctor, nurse, patient, patientFile, rendezVous);
         consultationFounded.setDate(new Date(0));
         consultationFounded.setTimeStart(new Date(0));
         patient.getRendezVouses().remove(rendezVous);
         doctor.getRendezVous().remove(rendezVous);
             create(consultationFounded);
             nurse.getConsultations().add(consultationFounded);
             doctor.getConsultations().add(consultationFounded);
             patient.getConsultations().add(consultationFounded);
             patientFile.getConsultations().add(consultationFounded);
         }
             return consultationFounded;
     }
    
}

