package serviceControl;


//import interfaces.IGlobal;

import interfaces.IGlobalInterfaces;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class RemoteObjects {

    private static IGlobalInterfaces globalRemote;


    public static IGlobalInterfaces getGlobalRemote() {
        return globalRemote;
    }
    
    
    
    public static void init() {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            globalRemote = (IGlobalInterfaces) registry.lookup("globalremote");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
