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
     public Doctor createDoctor(Service service,Nurse nurse,Date workDays,String CNI, String lastName, String FirstName, String sexe, String mail, int phoneNumber, String address, String password){
         Doctor doctorFounded= find(CNI);
         if(doctorFounded== null){
            doctorFounded= new Doctor(service,nurse,workDays,CNI, lastName, FirstName, sexe, mail, phoneNumber, address, password);
            create(doctorFounded);
            service.getDoctors().add(doctorFounded);
            nurse.setDoctor(doctorFounded);
            nurse.getWorkDays().add(workDays);
            
            
            
         }
             return doctorFounded;
     }
     
     public int removeDoctor(String CNI){
         Doctor doctorFounded= find(CNI);
         if( doctorFounded== null)
             return -1;
         else {
             Service service = doctorFounded.getService();
             Nurse nurse = doctorFounded.getNurse();
             remove(doctorFounded);
              service.getDoctors().remove(doctorFounded);
              nurse.setDoctor(null);
             return 1;
         }
     }
     
     public Doctor editDoctor(Service service,String CNI, String lastName, String FirstName, String mail, int phoneNumber, String address, String password){
         Doctor doctorFounded= find(CNI);
           if ( doctorFounded != null){
               Service exService = doctorFounded.getService();
               if (exService != service){
                   exService.getDoctors().remove(doctorFounded);
                   service.getDoctors().add(doctorFounded);
                   Nurse nurse = doctorFounded.getNurse();
                   nurse.setService(service);
               }
               doctorFounded.setLastName(lastName);
               doctorFounded.setFirstName(FirstName);
               doctorFounded.setMail(mail);
               doctorFounded.setPhoneNumber(phoneNumber);
               doctorFounded.setAddress(address);
               doctorFounded.setPassword(password);
               edit(doctorFounded);
           }  
              return doctorFounded;
         }
           
    
     }
