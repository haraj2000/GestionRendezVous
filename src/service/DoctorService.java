/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Doctor;
import bean.Nurse;
import bean.Service;
import java.util.Date;

/**
 *
 * @author Haraj
 */
public class DoctorService extends AbstractFacade<Doctor> {
    
    public DoctorService() {
        super(Doctor.class);
    }
     public Doctor createDoctor(Service service,Nurse nurse,Date workDays,String CNI, String lastName, String FirstName, String sexe, String mail, int phoneNumber, String country, String city, String address, String password){
         Doctor doctorFounded= find(CNI);
         if(doctorFounded== null){
            doctorFounded= new Doctor(service,nurse,workDays,CNI, lastName, FirstName, sexe, mail, phoneNumber, country, city, address, password);
            create(doctorFounded);
            service.getDoctors().add(doctorFounded);
            nurse.setDoctor(doctorFounded);
            nurse.getWorkDays().add(workDays);
            nurse.setPatientsFile(doctorFounded.getPatientFiles());
            
            
            
         }
             return doctorFounded;
     }
     
     public int removeDoctor(String CNI){
         Doctor doctorFounded= find(CNI);
         Service service = doctorFounded.getService();
         if( doctorFounded== null)
             return -1;
         else {
             remove(doctorFounded);
              service.getDoctors().remove(doctorFounded);
             return 1;
         }
     }
     
     public Doctor editDoctor(Service service,Nurse nurse,String CNI, String lastName, String FirstName, String sexe, String mail, int phoneNumber, String country, String city, String address, String password){
         Doctor doctorFounded= find(CNI);
             
              return doctorFounded;
         }
           
    
     }
