/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import bean.Doctor;
import java.util.Date;
import java.util.List;
/**
 *
 * @author blackswan
 */
public class DoctorService extends AbstractFacade<Doctor> {
    
     public DoctorService(){
        super(Doctor.class);
    }
     
     
        public int removeDoctor(String cin){
        Doctor doctorFounded = find(cin);
         if( doctorFounded== null)
             return -1;
         else {
             remove(doctorFounded);
             return 1;
         }
     }
        
         public int createDoctor(String cni, String lastName, String FirstName, String sexe, Date dayBirth, String mail, int phoneNumber, String address, String password){
         Doctor doctorFounded= find(cni);
         if(doctorFounded== null){
             doctorFounded= new Doctor(cni, lastName, FirstName, sexe, mail, phoneNumber, address, password, dayBirth);
             create(doctorFounded);
             return 1;
         }else
             return -1;
     }
         
          public int editAssistant(String cin, String lastName, String FirstName, String sexe, String mail, int phoneNumber, String address, String password)
     {
         Doctor doctorFounded= find(cin);
         if( doctorFounded!= null){
               doctorFounded.setLastName(lastName);
               doctorFounded.setFirstName(FirstName);
               doctorFounded.setMail(mail);
               doctorFounded.setPhoneNumber(phoneNumber);
               doctorFounded.setAddress(address);
               doctorFounded.setPassword(password);
               edit(doctorFounded);
               return 1;
         }else
            return -1;
     }
     
          public List<Doctor> findByCin(String cin){
        return getEntityManager().createQuery("SELECT d FROM Assistant d WHERE d.cin = '"+cin + "'").getResultList();
     }
     public List<Doctor> findByFirstName(String firstName){
        return getEntityManager().createQuery("SELECT d FROM Assistant d WHERE d.firstName = '"+firstName + "'").getResultList();    
     }
     public List<Doctor> findByLastName(String lastName){
        return getEntityManager().createQuery("SELECT d FROM Assistant d WHERE d.lastName = '"+lastName + "'").getResultList();
     }
     public List<Doctor> findByMail(String mail){
        return getEntityManager().createQuery("SELECT d FROM Assistant d WHERE d.mail = '"+mail + "'").getResultList();
     }
     public List<Doctor> findByPhoneNumber(int phoneNumber){
        return getEntityManager().createQuery("SELECT d FROM Assistant d WHERE d.phoneNumber = "+phoneNumber).getResultList();
     }
     @Override
     public List<Doctor> findAll(){
        return findAll();         
     }
}
    

