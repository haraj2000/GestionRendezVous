/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Checkout;
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
 
}
