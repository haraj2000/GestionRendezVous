/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.TypeAppointement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Haraj
 */
public class TypeAppointementServiceTest {
    
    public TypeAppointementServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createTypeAppointement method, of class TypeAppointementService.
     */
    @Test
    public void testCreateTypeAppointement() {
        System.out.println("createTypeAppointement");
        String reference = "";
        String libelle = "";
        String price = "";
        TypeAppointementService instance = new TypeAppointementService();
        int expResult = 0;
        int result = instance.createTypeAppointement(reference, libelle, price);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTypeAppointement method, of class TypeAppointementService.
     */
    @Test
    public void testRemoveTypeAppointement() {
        System.out.println("removeTypeAppointement");
        String reference = "";
        TypeAppointementService instance = new TypeAppointementService();
        int expResult = 0;
        int result = instance.removeTypeAppointement(reference);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editTypeAppointement method, of class TypeAppointementService.
     */
    @Test
    public void testEditTypeAppointement() {
        System.out.println("editTypeAppointement");
        String reference = "";
        String libelle = "";
        String price = "";
        TypeAppointementService instance = new TypeAppointementService();
        int expResult = 0;
        int result = instance.editTypeAppointement(reference, libelle, price);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByReference method, of class TypeAppointementService.
     */
    @Test
    public void testFindByReference() {
        System.out.println("findByReference");
        String reference = "";
        TypeAppointementService instance = new TypeAppointementService();
        TypeAppointement expResult = null;
        TypeAppointement result = instance.findByReference(reference);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByLibelle method, of class TypeAppointementService.
     */
    @Test
    public void testFindByLibelle() {
        System.out.println("findByLibelle");
        String libelle = "";
        TypeAppointementService instance = new TypeAppointementService();
        TypeAppointement expResult = null;
        TypeAppointement result = instance.findByLibelle(libelle);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
