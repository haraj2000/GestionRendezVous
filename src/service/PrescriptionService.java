/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Consultation;
import bean.Doctor;
import bean.Patient;
import bean.Prescription;
import java.util.Date;
import java.util.List;

/**
 *
 * @author blackswan
 */
public class PrescriptionService extends AbstractFacade<Prescription> {
    
    public PrescriptionService() {
        super(Prescription.class);
    }
  public Prescription createPrescription(String reference,Doctor doctor, Patient patient, List<String> medication, List<String> analyses, Date date, Consultation consultation){
         Prescription prescriptionFounded= find(reference);
         if(prescriptionFounded== null){
            prescriptionFounded= new Prescription(reference,doctor, patient, medication, analyses, date, consultation);
            create(prescriptionFounded);
         }
             return prescriptionFounded;
     }
     
     
     public Prescription editPrescription(String reference,Doctor doctor, Patient patient, List<String> medication, List<String> analyses, Date date, Consultation consultation)
     {
         Prescription prescriptionFounded= find(reference);
         if( prescriptionFounded== null)
         {
            prescriptionFounded= new Prescription(reference,doctor, patient, medication, analyses, date, consultation);
             create(prescriptionFounded);
         }
         else edit(prescriptionFounded);
             return prescriptionFounded;
     }

    
}
