/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Doctor;
import bean.Nurse;
import bean.Service;

/**
 *
 * @author Haraj
 */
public class DoctorService extends AbstractFacade<Doctor> {
    
    public DoctorService() {
        super(Doctor.class);
    }
     public Doctor createDoctor(Service service,Nurse nurse,String CNI, String lastName, String FirstName, String sexe, String mail, int phoneNumber, String country, String city, String address, String password){
         Doctor doctorFounded= find(CNI);
         if(doctorFounded== null){
            doctorFounded= new Doctor( service,nurse,CNI, lastName, FirstName, sexe, mail, phoneNumber, country, city, address, password);
            create(doctorFounded);
         }
             return doctorFounded;
     }
     
     public int removeDoctor(String CNI){
         Doctor doctorFounded= find(CNI);
         if( doctorFounded== null)
             return -1;
         else {
             remove(doctorFounded);
             return 1;
         }
     }
     
     public Doctor editDoctor(Service service,Nurse nurse,String CNI, String lastName, String FirstName, String sexe, String mail, int phoneNumber, String country, String city, String address, String password)
     {
         Doctor doctorFounded= find(CNI);
         if( doctorFounded!= null)
         edit(doctorFounded);
             return doctorFounded;
     }
    
}
