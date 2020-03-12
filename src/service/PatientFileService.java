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
    public PatientFile createPatientFile(String reference, Patient patient, float weight, float height, String bloodGroup, int tension, String notes, Insurance insurance, Doctor doctor){
         PatientFile patientFileFounded = find(reference);
         if(patientFileFounded == null){
             patientFileFounded = new PatientFile(reference, patient, weight, height, bloodGroup, tension, notes, insurance, doctor);
             create(patientFileFounded);
             doctor.getPatientFiles().add(patientFileFounded);
             insurance.getPatientFiles().add(patientFileFounded);
         }
             return patientFileFounded;
     }
    public PatientFile editPatientFile(String reference, float weight, float height, int tension, Insurance insurance, String notes)
     {
         PatientFile patientFileFounded = find(reference);
         Doctor doctor = patientFileFounded.getDoctor();
         Patient patient = patientFileFounded.getPatient();
         Insurance exInsurance = patientFileFounded.getInsurance();
         if( patientFileFounded != null){
            doctor.getPatientFiles().remove(patientFileFounded);
            exInsurance.getPatientFiles().remove(patientFileFounded);
            patient.getPatientFiles().remove(patientFileFounded);
         patientFileFounded.setWeight(weight);
         patientFileFounded.setHeight(height);
         patientFileFounded.setTension(tension);
         patientFileFounded.setInsurance(insurance);
         patientFileFounded.setNotes(notes);
         
      edit(patientFileFounded);
         doctor.getPatientFiles().add(patientFileFounded);
         insurance.getPatientFiles().add(patientFileFounded);
         patient.getPatientFiles().add(patientFileFounded);
         }
             return patientFileFounded;
     }
    
    
}
