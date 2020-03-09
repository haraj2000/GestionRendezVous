/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Service;

/**
 *
 * @author Haraj
 */
public class ServiceService extends AbstractFacade<Service>{

    public ServiceService() {
        super(Service.class);
    }
    
    
 public Service createService(String reference, String libelle){
         Service serviceFounded = find(reference);
         if(serviceFounded == null){
             serviceFounded = new Service(reference, libelle);
             create(serviceFounded);
         }
             return serviceFounded;
     }
     
     public int removeservice(String reference){
         Service serviceFounded = find(reference);
         if( serviceFounded == null)
             return -1;
         else {
             remove(serviceFounded);
             return 1;
         }
     }
     
     public Service editservice(String reference, String libelle)
     {
         Service serviceFounded = find(reference);
         if( serviceFounded == null)
         {
             serviceFounded = new Service(reference, libelle);
             create(serviceFounded);
         }
         else edit(serviceFounded);
             return serviceFounded;
     }   
}
