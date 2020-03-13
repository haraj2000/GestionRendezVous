/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Checkout;
import bean.Consultation;
import bean.Doctor;
import bean.Patient;
import bean.Appointement;
import java.util.Date;
/**
 *
 * @author blackswan
 */
public class CheckoutService extends AbstractFacade<Checkout> {
    
    public CheckoutService() {
        super(Checkout.class);
    }
  public Checkout createCheckout(String reference, Double price, Appointement nextRDV, Patient patient, Doctor doctor, Consultation consultation){
         Checkout checkoutFounded= find(reference);
         if(checkoutFounded== null){
            checkoutFounded= new Checkout(reference, price, nextRDV, patient, doctor, consultation);
            RendezVousService rendezVousService = null;
            rendezVousService.create(nextRDV);
            create(checkoutFounded);
            consultation.setCheckout(checkoutFounded);
            consultation.setTimeEnd(new Date(0));
         }
             return checkoutFounded;
     }

}
