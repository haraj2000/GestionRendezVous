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
public class NusreService extends AbstractFacade<Nurse>{

    public NusreService() {
        super(Nurse.class);
    }
    
    public Nurse createNurse(Service service, Doctor doctor, String CNI, String lastName, String FirstName, String sexe, String mail, int phoneNumber, String address, String password){
        Nurse nurseFounded = find(CNI);
        if(nurseFounded == null){
            if (doctor.getNurse() ==null){
            nurseFounded = new Nurse(service, doctor, CNI, lastName, FirstName, sexe, mail, phoneNumber, address, password);
            create(nurseFounded);
            service.getNurses().add(nurseFounded);
            doctor.setNurse(nurseFounded);
                    }
        }
        return nurseFounded;
    }
    public int removeNurse(String CNI){
         Nurse nurseFounded = find(CNI);
         Service service = nurseFounded.getService();
         Doctor doctor = nurseFounded.getDoctor();
         if( nurseFounded == null)
             return -1;
         else {
             remove(nurseFounded);
             service.getNurses().remove(nurseFounded);
             doctor.setNurse(null);
             return 1;
         }
     }
     
     public Nurse editNurse(Service service, Doctor doctor, String CNI, String mail, int phoneNumber, String address, String password)
     {
         Nurse nurseFounded = find(CNI);
         if( nurseFounded != null){
             Service exService = nurseFounded.getService();
             Doctor exDoctor = nurseFounded.getDoctor();
             if (exDoctor != doctor)
             {if(doctor.getNurse()!=null)
                 return nurseFounded;
             else{
                 exDoctor.setNurse(null);
                 doctor.setNurse(nurseFounded);
             if (exService != service)
             {
                 exService.getNurses().remove(nurseFounded);
                 service.getNurses().add(nurseFounded);
             }
             
            nurseFounded.setService(service);
            nurseFounded.setDoctor(doctor);
            nurseFounded.setMail(mail);
            nurseFounded.setPhoneNumber(phoneNumber);
            nurseFounded.setAddress(address);
            nurseFounded.setPassword(password);
            edit(nurseFounded);
            return nurseFounded;
             } 
         }
         
     }
        return nurseFounded;
     }
}
