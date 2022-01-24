package me.damianciepiela;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiServerInt extends Remote {
    String calculate(String equation) throws RemoteException;
    String translate(String equation) throws RemoteException;
}
