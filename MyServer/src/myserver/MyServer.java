/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myserver;

import interfaces.IGlobalInterfaces;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Bouya
 */
public class MyServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
          
         System.setSecurityManager(new SecurityManager());
            Registry registry = LocateRegistry.createRegistry(1099);
            IGlobalInterfaces glo = new daoImplement.GlobalDao();
            registry.bind("globalremote", glo);
           
            System.out.println("serveur en attente de connexion");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("erreur");
        }
    }
    
}
