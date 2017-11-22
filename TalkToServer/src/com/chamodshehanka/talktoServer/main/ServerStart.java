package com.chamodshehanka.talktoServer.main;

import com.chamodshehanka.talktoServer.controllerImpl.TalkToFactoryImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author chamodshehanka on 11/19/2017
 * @project TalkToGroupChat
 **/
public class ServerStart {
    public static void main(String[] args) {
        try {
            Registry talkToRegistry = LocateRegistry.createRegistry(5050);
            System.out.println("Talk To Server is starting");
            talkToRegistry.rebind("TalkToServer", new TalkToFactoryImpl());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
