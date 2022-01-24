package me.damianciepiela;

import me.damianciepiela.onp.ONP;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiServer extends UnicastRemoteObject implements RmiServerInt {

    private final ONP onp = new ONP();

    public RmiServer() throws RemoteException {
    }

    public RmiServer(int port) throws RemoteException {
        super(port);
    }

    @Override
    public String calculate(String equation) throws RemoteException {
        return onp.obliczOnp(equation);
    }

    @Override
    public String translate(String equation) throws RemoteException {
        return onp.przeksztalcNaOnp(equation);
    }
}
