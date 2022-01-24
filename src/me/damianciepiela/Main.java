package me.damianciepiela;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

    public static void main(String[] args) {
        String type = args[0];
        if (type.equals("-server")) {
            try {
                RmiServerInt rmiServerInt = new RmiServer();
                Registry registry = LocateRegistry.createRegistry(8080);
                registry.bind("RMI", rmiServerInt);
            } catch (RemoteException | AlreadyBoundException e) {
                e.printStackTrace();
            }
        } else {
            RmiClient rmiClient = new RmiClient();
            rmiClient.run();
        }
    }

}
