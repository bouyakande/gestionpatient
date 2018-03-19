
package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Employe;




public interface IEmploye extends Remote{
    
    public int addEmploye(Employe em) throws RemoteException;
    public int udpdateEmployer (Employe em) throws RemoteException;
    public Employe searchEmploye(String mat) throws RemoteException;
    public List<Employe> listeEmploye() throws RemoteException;

}
