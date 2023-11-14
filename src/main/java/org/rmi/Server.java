package org.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements RemoteObject {

    public Server() {}

    @Override
    public String sayHelloWorld() throws RemoteException {
        return "Hello World!";
    }

    public static void main(String args[]) {

        try {
            var obj = new Server();
            var stub = (RemoteObject) UnicastRemoteObject.exportObject(obj, 0);

            var registry = LocateRegistry.createRegistry(3000);
            registry.bind("remote-object", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
