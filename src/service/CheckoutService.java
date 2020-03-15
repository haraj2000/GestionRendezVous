/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Appointement;
import bean.Checkout;

/**
 *
 * @author blackswan
 */
public class CheckoutService extends AbstractFacade<Checkout> {
    
    public CheckoutService() {
        super(Checkout.class);
    }
    public int createCheckout(String reference, Appointement nextAppointement, Appointement currentAppointement){
         Checkout checkoutFounded = find(reference);
        if(checkoutFounded== null){
            checkoutFounded = new Checkout(reference, nextAppointement, currentAppointement);
            create(checkoutFounded);
            return 1;
         } else
            return -1;
    } 
    public Checkout findByReference(String reference){
        return (Checkout) getEntityManager().createQuery("SELECT c FROM Checkout c WHERE c.reference = '"+reference + "'").getSingleResult();
     }
    public Checkout findByCurrentAppointement(Appointement currentAppointement){
        return (Checkout) getEntityManager().createQuery("SELECT c FROM Checkout c WHERE c.currentAppointement = '"+currentAppointement + "'").getSingleResult();
     }
}
