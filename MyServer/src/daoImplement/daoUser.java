package daoImplement;

import interfaces.Iusers;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import model.Employe;
import model.User;
import service.ServiceJPA;
import static service.MySingleton.*;
public class daoUser implements Iusers {

    @Override
    public int addUser(User user) throws RemoteException {
        int a = 0;
        EntityManager usr = ServiceJPA.getEM();
        usr.getTransaction().begin();
        try {

            usr.persist(user);
            usr.flush();
            usr.getTransaction().commit();
            a = 1;
        } catch (Exception e) {
            usr.getTransaction().rollback();
            System.out.println("erreur sur le server");

        }
        return a;
    }

    @Override
    public List<User> oblistUser() throws RemoteException {
        EntityManager usr = ServiceJPA.getEM();
        usr.getTransaction().begin();
        List<User> lp = usr.createNamedQuery("User.findAll").getResultList();

        return lp;
    }

    @Override
    public int updateUser(User user) throws RemoteException {
        EntityManager usr = ServiceJPA.getEM();
        int a = 0;
        usr.getTransaction().begin();
        try {

            usr.merge(user);
            usr.flush();
            usr.getTransaction().commit();
            a = 1;
        } catch (Exception e) {
            usr.getTransaction().rollback();
            System.out.println("erreur sur le server");
            // e.printStackTrace();
        }
        return a;
    }

    @Override
    public int blocUser(String mat) throws RemoteException {
        EntityManager usr = ServiceJPA.getEM();
        int a = 0;
        daoEmploye dem = new daoEmploye();
        Employe e = dem.searchEmploye(mat);
        
        Collection<User> lp = e.getUserList();
        
        String statut = "bloquer";
        for (User u : lp) {
            u.setStatut(statut);
            usr.getTransaction().begin();
            try {

                usr.merge(u);
                usr.flush();
                usr.getTransaction().commit();
                a = 1;
            } catch (Exception ex) {
                usr.getTransaction().rollback();
                System.out.println("erreur sur le server");
                // e.printStackTrace();
            }

        }
        return a;
    }

    @Override
    public User connexion(String login, String password) throws RemoteException {
        EntityManager usr = ServiceJPA.getEM();
        List<User> us = usr.createNamedQuery("User.findAll").getResultList();
        User u = getInstanceUser();
        for (User ur : us) {
            
            if(ur.getLogin().equals(login) && ur.getPassword().equals(password))
            {
                u = ur;
            }
        }
        return u;
    }

    @Override
    public int deblocUser(String mat) throws RemoteException {
       EntityManager usr = ServiceJPA.getEM();
        int a = 0;
        daoEmploye dem = new daoEmploye();
        Employe e = dem.searchEmploye(mat);
        
        Collection<User> lp = e.getUserList();
        
        String statut = "debloquer";
        for (User u : lp) {
            u.setStatut(statut);
            usr.getTransaction().begin();
            try {

                usr.merge(u);
                usr.flush();
                usr.getTransaction().commit();
                a = 1;
            } catch (Exception ex) {
                usr.getTransaction().rollback();
                System.out.println("erreur sur le server");
                // e.printStackTrace();
            }

        }
        return a;
    }

}
