/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImplement;

import com.sun.net.httpserver.Authenticator;
import java.rmi.RemoteException;
import java.util.List;
import model.Employe;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import model.Employe;

/**
 *
 * @author Bouya
 */
public class daoEmployeTest {

    public daoEmployeTest() {
    }

    /**
     * Test of addEmploye method, of class daoEmploye.
     */
    
    @Test
    public void testAddEmploye() throws Exception {
        System.out.println("addEmploye");
        Employe em = new Employe();
        em.setAdresse("adr");
        em.setEmail("mail");
        em.setFonction("fonction");
        em.setMatricule("matri");
        em.setNom("nom");
        em.setPrenom("prenom");
        em.setTelephone("tel");
        if (em.getAdresse() == null || em.getEmail() == null || em.getFonction() == null || em.getMatricule() == null
                || em.getNom() == null || em.getPrenom() == null || em.getTelephone() == null) {
            fail("toutes les champs doivent etre renseigner");
        } else {
            daoEmploye instance = new daoEmploye();
            int expResult = 0;
            int result = instance.addEmploye(em);
            if (expResult == result) {
                
                System.out.println("ajouter");
            }
        }

    }
     
    /**
     * Test of udpdateEmployer method, of class daoEmploye.
     */
    @Test
    public void testUdpdateEmployer() throws Exception {
        System.out.println("udpdateEmployer");
        String mat = "mat2bou";
        daoEmploye instance = new daoEmploye();
        Employe e = instance.searchEmploye(mat);
        e.setNom("charice");
        int expResult = 0;
        int result = instance.udpdateEmployer(e);
        if (expResult == result) {

            fail("non modifié");
        }
        else
        {
            System.out.println("modifié");
        }
        
        
    }

    /**
     * Test of searchEmploye method, of class daoEmploye.
     */
      @Test
    public void testSearchEmploye() throws RemoteException {
        System.out.println("searchEmploye");
        String mat = "mat2bou";
        if(mat.equals(""))
        {
            fail("sasir le matricul à rechercher");
        }else
        {
         daoEmploye instance = new daoEmploye();
        Employe expResult = null;
        Employe result = instance.searchEmploye(mat);
        if(expResult==result)
        {
            fail("employer non trouver");
        }
        else
        {
            System.out.println("employer trouver");
        }
        }
        
    }
    /**
     * Test of listeEmploye method, of class daoEmploye.
     */
    @Test
    public void testListeEmploye() throws Exception {
        System.out.println("listeEmploye");
        daoEmploye instance = new daoEmploye();
        List<Employe> expResult = null;
        List<Employe> result = instance.listeEmploye();
        if(expResult== result)
        {
            fail("la liste est vide");
        }
        else{
            System.out.println("la liste n'est pas vide");
        }
        
        
        
    }
}
