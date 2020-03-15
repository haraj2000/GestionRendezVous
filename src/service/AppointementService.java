/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import bean.Appointement;
import bean.Doctor;
import bean.Patient;
import bean.TypeAppointement;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Haraj
 */
public class AppointementService extends AbstractFacade<Appointement>{

    private final TypeAppointementService typeAppointementService = new TypeAppointementService();
    public AppointementService() {
        super(Appointement.class);
    }
    public int createAppointement(Appointement appointement){
        Appointement appointementFounded = find(appointement.getReference());
        if(appointementFounded== null){
            TypeAppointement appointementType = typeAppointementService.find(appointement.getTypeAppointement().getReference());
            appointementType.getAppointements().add(appointementFounded);
            appointementFounded= new Appointement(appointement.getReference(), appointement.getDateAppointement(), appointement.getHourAppointement(), appointementType, appointement.getPatient(), appointement.getDoctor());
            appointementFounded.setEtatAppointement("Waiting");
            create(appointementFounded);
            return 1;
         } else
            return -1;
    }  
     public int removeAppointement(String reference){
         Appointement appointementFounded = find(reference);
         if( appointementFounded== null)
             return -1;
         else {
             remove(appointementFounded);
             return 1;
         }
     }
     public int editAppointement(String reference, Date dateAppointement, Date hourAppointement, TypeAppointement typeAppointement, Patient patient, Doctor doctor)
     {
         Appointement appointementFounded = find(reference);
         if( appointementFounded!= null){
             if(typeAppointement!= appointementFounded.getTypeAppointement())
             {
                 typeAppointementService.find(appointementFounded.getTypeAppointement()).getAppointements().remove(appointementFounded);
                 typeAppointementService.find(typeAppointement.getAppointements().add(appointementFounded));
             }
               appointementFounded.setDateAppointement(dateAppointement);
               appointementFounded.setHourAppointement(hourAppointement);
               appointementFounded.setTypeAppointement(typeAppointement);
               appointementFounded.setDoctor(doctor);
               edit(appointementFounded);
               return 1;
         }else
            return -1;
     }
         public Appointement findByReference(String reference){
        return (Appointement) getEntityManager().createQuery("SELECT a FROM Appointement a WHERE a.reference = '"+reference + "'").getSingleResult();
     }
        public List<Appointement> findByDateAppointement(Date dateAppointement){
        return getEntityManager().createQuery("SELECT a FROM Appointement a WHERE a.dateAppointement = "+dateAppointement).getResultList();
     }
        public List<Appointement> findByTypeAppointement(TypeAppointement typeAppointement){
        return getEntityManager().createQuery("SELECT a FROM Appointement a WHERE a.typeAppointement = '"+typeAppointement + "'").getResultList();
     }
        public List<Appointement> findByDoctor(Doctor doctor){
        return getEntityManager().createQuery("SELECT a FROM Appointement a WHERE a.doctor = '"+doctor + "'").getResultList();
     }
         @Override
        public List<Appointement> findAll(){
         return findAll();
     }
}
