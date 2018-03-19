/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImplement;

import java.util.List;
import model.Employe;
import model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bouya
 */
public class daoUserTest {

    public daoUserTest() {
    }

    /**
     * Test of addUser method, of class daoUser.
     */
     @Test
    public void testAddUser() throws Exception {
        System.out.println("addUser");
        
        User user = new User();
        daoUser instance = new daoUser();
        Employe em = new Employe();
        em.setIdemp(1);
        user.setIdemp(em);
        user.setLogin("passer");
        user.setPassword("passer");
        user.setProfil("admin");
        user.setStatut("debloquer");
        
        
         if (user.getIdemp() == null || user.getLogin() == null || user.getPassword() == null || user.getProfil() == null
                || user.getStatut() == null) {
            fail("toutes les champs doivent etre renseigner");
        } else {
            
            int expResult = 0;
            int result = instance.addUser(user);
            if (expResult == result) {
                
                fail("non ajouter");
            }
            else{
                System.out.println("ajouter");
            }
            
        }
        
    }
    /**
     * Test of oblistUser method, of class daoUser.
     */
    @Test
    public void testOblistUser() throws Exception {
        System.out.println("oblistUser");
        daoUser instance = new daoUser();
        List<User> expResult = null;
        List<User> result = instance.oblistUser();
        if (expResult == result) {

            fail("la liste est vide");
        } else {
            System.out.println("la liste est non vide");
        }
    }

    /**
     * Test of updateUser method, of class daoUser.
     */
     @Test
    public void testUpdateUser() throws Exception {
        System.out.println("updateUser");
        User user = null;
        daoUser instance = new daoUser();
        int expResult = 0;
        int result = instance.updateUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of blocUser method, of class daoUser.
     */
  @Test
    public void testBlocUser() throws Exception {
        System.out.println("blocUser");
        String mat = "";
        daoUser instance = new daoUser();
        int expResult = 0;
        int result = instance.blocUser(mat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of connexion method, of class daoUser.
     */
   @Test
    public void testConnexion() throws Exception {
        System.out.println("connexion");
        String login = "login";
        String password = "passer";
        daoUser instance = new daoUser();
        User expResult = null;
        User result = instance.connexion(login, password);
        if(expResult==result)
        {
            System.out.println("echec connexion");
        }else
        {
            System.out.println("reussit connexion");
        }
        
    }

    /**
     * Test of deblocUser method, of class daoUser.
     */
  @Test
    public void testDeblocUser() throws Exception {
        System.out.println("deblocUser");
        String mat = "";
        daoUser instance = new daoUser();
        int expResult = 0;
        int result = instance.deblocUser(mat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
