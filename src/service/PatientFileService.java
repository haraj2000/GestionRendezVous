/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Doctor;
import bean.Insurance;
import bean.Patient;
import bean.PatientFile;

/**
 *
 * @author Haraj
 */
public class PatientFileService extends AbstractFacade<PatientFile>{

    public PatientFileService() {
        super(PatientFile.class);
    }
    public PatientFile createPatientFile(String reference, Patient patient, float weight, float height, String bloodGroup, int tension, Insurance insurance, Doctor doctor){
         PatientFile patientFileFounded = find(reference);
         if(patientFileFounded == null){
             patientFileFounded = new PatientFile(reference, patient, weight, height, bloodGroup, tension, insurance, doctor);
             create(patientFileFounded);
         }
             return patientFileFounded;
     }
    public PatientFile editPatientFile(String reference, Patient patient, float weight, float height, String bloodGroup, int tension, Insurance insurance, Doctor doctor)
     {
         PatientFile patientFileFounded = find(reference);
         if( patientFileFounded != null)
      edit(patientFileFounded);
             return patientFileFounded;
     }
    
    
}
