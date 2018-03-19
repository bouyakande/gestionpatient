package daoImplement;

import interfaces.IEmploye;
import java.rmi.RemoteException;
import java.util.List;
import javax.persistence.EntityManager;
import model.Employe;
import service.ServiceJPA;

public class daoEmploye implements IEmploye {

    @Override
    public int addEmploye(Employe em) throws RemoteException {
        int a = 0;
        EntityManager emp = ServiceJPA.getEM();
        emp.getTransaction().begin();
        try {

            emp.persist(em);
            emp.flush();
            emp.getTransaction().commit();
            a = 1;
        } catch (Exception e) {
            emp.getTransaction().rollback();
            System.out.println("erreur sur le server");
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public int udpdateEmployer(Employe em) throws RemoteException {
        EntityManager emp = ServiceJPA.getEM();
        int a = 0;
        emp.getTransaction().begin();
        try {
            emp.merge(em); //mm chose mais Ã  la place de persiste c'est merge
            emp.flush();
            emp.getTransaction().commit();

            a = 1;
        } catch (Exception e) {
            emp.getTransaction().rollback();
            e.printStackTrace();

        }

        return a;
    }

    @Override
    public Employe searchEmploye(String mat) throws RemoteException {
        EntityManager emp = ServiceJPA.getEM();
        List<Employe> em = emp.createNamedQuery("Employe.findByMatricule").setParameter("matricule", mat).getResultList();
        Employe ep = new Employe();
        for (Employe employe : em) {
            ep = employe;
        }
        return ep;
    }

    @Override
    public List<Employe> listeEmploye() throws RemoteException {
        EntityManager emp = ServiceJPA.getEM();
        List<Employe> em = emp.createNamedQuery("Employe.findAll").getResultList();
        return em;
    }
}
