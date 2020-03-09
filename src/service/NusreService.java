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
    
    public Nurse createNurse(Service service, Doctor doctor, String CNI, String lastName, String FirstName, String sexe, String mail, int phoneNumber, String country, String city, String address, String password){
        Nurse nurseFounded = find(CNI);
        if(nurseFounded == null){
            nurseFounded = new Nurse(service, doctor, CNI, lastName, FirstName, sexe, mail, phoneNumber, country, city, address, password);
            create(nurseFounded);
                    }
        return nurseFounded;
    }
    public int removeNurse(String CNI){
         Nurse nurseFounded = find(CNI);
         if( nurseFounded == null)
             return -1;
         else {
             remove(nurseFounded);
             return 1;
         }
     }
     
     public Nurse editNurse(Service service, Doctor doctor, String CNI, String lastName, String FirstName, String sexe, String mail, int phoneNumber, String country, String city, String address, String password)
     {
         Nurse nurseFounded = find(CNI);
         if( nurseFounded == null)
         {
             nurseFounded = new Nurse (service, doctor, CNI, lastName, FirstName, sexe, mail, phoneNumber, country, city, address, password);
             create(nurseFounded);
         }
         else edit(nurseFounded);
             return nurseFounded;
     }
}
