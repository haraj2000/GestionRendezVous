/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.TypeAppointement;

/**
 *
 * @author Haraj
 */
public class TypeAppointementService extends AbstractFacade<TypeAppointement>{
    
    public TypeAppointementService(){
        super(TypeAppointement.class);
    }
    public int createTypeAppointement(String reference, String libelle, String price){
        TypeAppointement typeAppointementFounded = find(reference);
        if (typeAppointementFounded== null){
            typeAppointementFounded = new TypeAppointement(reference, libelle, price);
            create(typeAppointementFounded);
            return 1;
        }else return -1;
    }
     public int removeTypeAppointement(String reference){
         TypeAppointement typeAppointementFounded = find(reference);
         if( typeAppointementFounded== null)
             return -1;
         else {
             remove(typeAppointementFounded);
             return 1;
         }
     }
     public int editTypeAppointement(String reference, String libelle, String price)
     {
         TypeAppointement typeAppointementFounded = find(reference);
         if( typeAppointementFounded!= null){
               typeAppointementFounded.setLibelle(libelle);
               typeAppointementFounded.setPrice(price);
               edit(typeAppointementFounded);
               return 1;
         }else
            return -1;
     }
      public TypeAppointement findByReference(String reference){
        return (TypeAppointement) getEntityManager().createQuery("SELECT t FROM TypeAppointement t WHERE t.reference = '"+reference + "'").getSingleResult();
     }
      public TypeAppointement findByLibelle(String libelle){
        return (TypeAppointement) getEntityManager().createQuery("SELECT t FROM TypeAppointement t WHERE t.libelle = '"+libelle + "'").getSingleResult();
     }
}
