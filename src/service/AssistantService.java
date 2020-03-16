/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Assistant;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Haraj
 */
public class AssistantService extends AbstractFacade<Assistant>{
    
     public AssistantService() {
        super(Assistant.class);
    }
     public int createAssistant(String cin, String lastName, String FirstName, String sexe, Date dayBirth, String mail, int phoneNumber, String address, String password){
         Assistant assistantFounded= find(cin);
         if(assistantFounded== null){
             assistantFounded= new Assistant(cin, lastName, FirstName, sexe, dayBirth, mail, phoneNumber, address, password);
             create(assistantFounded);
             return 1;
         }else
             return -1;
     }
     
     public int removeAssistant(String cin){
         Assistant assistantFounded= find(cin);
         if( assistantFounded== null)
             return -1;
         else {
             remove(assistantFounded);
             return 1;
         }
     }
     
     public int editAssistant(String cin, String lastName, String FirstName, String sexe, String mail, int phoneNumber, String address, String password)
     {
         Assistant assistantFounded= find(cin);
         if( assistantFounded!= null){
               assistantFounded.setLastName(lastName);
               assistantFounded.setFirstName(FirstName);
               assistantFounded.setMail(mail);
               assistantFounded.setPhoneNumber(phoneNumber);
               assistantFounded.setAddress(address);
               assistantFounded.setPassword(password);
               edit(assistantFounded);
               return 1;
         }else
            return -1;
     }
     public List<Assistant> findByCin(String cin){
        return getEntityManager().createQuery("SELECT a FROM Assistant a WHERE a.cin = '"+cin + "'").getResultList();
     }
     public List<Assistant> findByFirstName(String firstName){
        return getEntityManager().createQuery("SELECT a FROM Assistant a WHERE a.firstName = '"+firstName + "'").getResultList();    
     }
     public List<Assistant> findByLastName(String lastName){
        return getEntityManager().createQuery("SELECT a FROM Assistant a WHERE a.lastName = '"+lastName + "'").getResultList();
     }
     public List<Assistant> findByMail(String mail){
        return getEntityManager().createQuery("SELECT a FROM Assistant a WHERE a.mail = '"+mail + "'").getResultList();
     }
     public List<Assistant> findByPhoneNumber(int phoneNumber){
        return getEntityManager().createQuery("SELECT a FROM Assistant a WHERE a.phoneNumber = "+phoneNumber).getResultList();
     }
     @Override
     public List<Assistant> findAll(){
        return findAll();         
     }
}
