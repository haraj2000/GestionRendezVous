/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Insurance;
/**
 *
 * @author Haraj
 */
public class InsuranceService extends AbstractFacade<Insurance> {

 public InsuranceService() {
        super(Insurance.class);
    }
  public Insurance createInsurance(String libelle,double monthlyCost){
         Insurance insuranceFounded= find(libelle);
         if(insuranceFounded== null){
            insuranceFounded= new Insurance( libelle,monthlyCost);
            create(insuranceFounded);
         }
             return insuranceFounded;
     }
     
     public int removeInsurance(String libelle){
         Insurance insuranceFounded= find(libelle);
         if( insuranceFounded== null)
             return -1;
         else {
             remove(insuranceFounded);
             return 1;
         }
     }
     
     public Insurance editInsurance(String libelle,double monthlyCost)
     {
         Insurance insuranceFounded= find(libelle);
         if( insuranceFounded!= null)
        edit(insuranceFounded);
             return insuranceFounded;
     }


 
}
