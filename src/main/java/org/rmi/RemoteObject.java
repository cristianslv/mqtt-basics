package org.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteObject extends Remote {
    String sayHelloWorld() throws RemoteException;
}
