package org.rmi;

import java.rmi.registry.LocateRegistry;

public class Client {

    public static void main(String[] args) {
        var host = (args.length < 1) ? null : args[0];

        try {
            var registry = LocateRegistry.getRegistry(host, 3000);
            var remoteObject = (RemoteObject) registry.lookup("remote-object");
            var response = remoteObject.sayHelloWorld();

            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
