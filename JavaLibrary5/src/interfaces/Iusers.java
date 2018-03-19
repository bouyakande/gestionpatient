
package interfaces;

import java.rmi.*;
import java.util.List;
import model.User;
public interface Iusers extends Remote{
     public int addUser(User user) throws RemoteException;

    public List<User> oblistUser() throws RemoteException;

    public int updateUser(User user) throws RemoteException;

    public int blocUser(String mat) throws RemoteException;

    public User connexion(String login, String password) throws RemoteException;

    public int deblocUser(String mat) throws RemoteException;
}
