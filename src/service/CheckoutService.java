/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Checkout;
import bean.Doctor;
import bean.Patient;
import bean.RendezVous;
/**
 *
 * @author blackswan
 */
public class CheckoutService extends AbstractFacade<Checkout> {
    
    public CheckoutService() {
        super(Checkout.class);
    }
  public Checkout createCheckout(String reference,Double price,RendezVous nextRDV,Patient patient,Doctor doctor){
         Checkout checkoutFounded= find(reference);
         if(checkoutFounded== null){
            checkoutFounded= new Checkout( reference,price, nextRDV, patient, doctor);
            create(checkoutFounded);
         }
             return checkoutFounded;
     }
  
     
     public Checkout editCheckout(String reference,Double price,RendezVous nextRDV,Patient patient,Doctor doctor)
     {
         Checkout checkoutFounded= find(reference);
         if( checkoutFounded== null)
         {
            checkoutFounded= new Checkout( reference,price, nextRDV, patient, doctor);
             create(checkoutFounded);
         }
         else edit(checkoutFounded);
             return checkoutFounded;
     }


    
}
