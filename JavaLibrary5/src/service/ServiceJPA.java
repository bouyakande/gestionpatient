package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ServiceJPA {

    public static EntityManager getEM() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JavaLibraryMyProjetPU");
        return factory.createEntityManager();
    }
}
