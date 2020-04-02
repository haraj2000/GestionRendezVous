/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import bean.Patient;
import java.util.Date;
/**
 *
 * @author Haraj
 */
public class PatientService extends AbstractFacade<Patient> {
    
    public PatientService() {
        super(Patient.class);
    }
    
   
     
     public Patient editPatient(Date dayBirth,String CNI, String lastName, String FirstName, String sexe, String mail, int phoneNumber, String country, String city, String address, String password)
     {
         Patient patientFounded= find(CNI);
         if( patientFounded!= null)
         edit(patientFounded);
             return patientFounded;
     }
    
}
