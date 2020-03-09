/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Assistant;

/**
 *
 * @author Haraj
 */
public class AssistantService extends AbstractFacade<Assistant>{
    
     public AssistantService() {
        super(Assistant.class);
    }
     public Assistant createAssistant(String CNI, String lastName, String FirstName, String sexe, String mail, int phoneNumber, String country, String city, String address, String password){
         Assistant assistantFounded= find(CNI);
         if(assistantFounded== null){
             assistantFounded= new Assistant(CNI, lastName, FirstName, sexe, mail, phoneNumber, country, city, address, password);
             create(assistantFounded);
         }
             return assistantFounded;
     }
     
     public int removeAssistant(String CNI){
         Assistant assistantFounded= find(CNI);
         if( assistantFounded== null)
             return -1;
         else {
             remove(assistantFounded);
             return 1;
         }
     }
     
     public Assistant editAssistant(String CNI, String lastName, String FirstName, String sexe, String mail, int phoneNumber, String country, String city, String address, String password)
     {
         Assistant assistantFounded= find(CNI);
         if( assistantFounded== null)
         {
             assistantFounded= new Assistant(CNI, lastName, FirstName, sexe, mail, phoneNumber, country, city, address, password);
             create(assistantFounded);
         }
         else edit(assistantFounded);
             return assistantFounded;
     }
}
