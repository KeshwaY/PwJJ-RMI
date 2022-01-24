package me.damianciepiela;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RmiClient {

    public void run() {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 8080);
            RmiServerInt stub = (RmiServerInt) registry.lookup("RMI");
            boolean run = true;
            while (run) {
                System.out.println("Enter equation (eg. 1 + 1) or enter 'q' to exit:");
                Scanner scanner = new Scanner(System.in);
                String userInput = scanner.nextLine();
                if (userInput.equals("q")) {
                    run = false;
                } else {
                    try {
                        if (userInput.matches(".*[a-z].*")) {
                            throw new Exception();
                        }
                        if (!userInput.contains("=")) {
                            userInput = userInput + "=";
                        }
                        String onp = stub.translate(userInput);
                        String result = stub.calculate(onp);
                        System.out.println(result);
                    } catch (Exception e) {
                        System.out.println("Invalid input");
                    }
                }
            }
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

}
