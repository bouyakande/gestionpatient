/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImplement;

import interfaces.IGlobalInterfaces;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.Employe;
import model.User;

/**
 *
 * @author Bouya
 */
public class GlobalDao extends UnicastRemoteObject implements IGlobalInterfaces{
    
    public GlobalDao() throws RemoteException {
        super();
    }

         // ---------------- classe user -----------------
    @Override
    public int addUser(User user) throws RemoteException {
        daoUser u = new daoUser();
      return  u.addUser(user);
    }

    @Override
    public List<User> oblistUser() throws RemoteException {
       daoUser u = new daoUser();
       return u.oblistUser();
    }

    @Override
    public int updateUser(User user) throws RemoteException {
       daoUser u = new daoUser();
       return u.updateUser(user);
    }

    @Override
    public int blocUser(String mat) throws RemoteException {
        daoUser u = new daoUser();
        return u.blocUser(mat);
    }

    @Override
    public User connexion(String login, String password) throws RemoteException {
        daoUser u = new daoUser();
        return u.connexion(login, password);
    }

    @Override
    public int deblocUser(String mat) throws RemoteException {
        daoUser u = new daoUser();
        return u.deblocUser(mat);
    }

    // ---------------- classe employe -----------------
    
    @Override
    public int addEmploye(Employe em) throws RemoteException {
        daoEmploye emp = new daoEmploye();
        return emp.addEmploye(em);
    }

    @Override
    public int udpdateEmployer(Employe em) throws RemoteException {
        daoEmploye emp = new daoEmploye();
        return emp.udpdateEmployer(em);
    }

    @Override
    public Employe searchEmploye(String mat) throws RemoteException {
        daoEmploye emp = new daoEmploye();
        return emp.searchEmploye(mat);
    }

    @Override
    public List<Employe> listeEmploye() throws RemoteException {
        daoEmploye emp = new daoEmploye();
        return emp.listeEmploye();
    }
    
}
