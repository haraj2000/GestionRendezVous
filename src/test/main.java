/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import bean.TypeAppointement;
import service.TypeAppointementService;

/**
 *
 * @author Haraj
 */
public class main {
    public static void main(String[] args) {
        TypeAppointement type = new TypeAppointement("ref1", "lib1", "10");
        TypeAppointementService typeService = new TypeAppointementService();
        typeService.create(type);
    }
}
