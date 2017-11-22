package com.chamodshehanka.talktoClient.connector;

import com.chamodshehanka.talktoCommon.controller.ChatController;
import com.chamodshehanka.talktoCommon.controller.TalkToFactory;
import com.chamodshehanka.talktoCommon.controller.UserController;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author chamodshehanka on 11/19/2017
 * @project TalkToGroupChat
 **/
public class ServerConnector {

    private static ServerConnector serverConnector;
    private UserController userController;
    private ChatController chatController;
    private TalkToFactory talkToFactory;

    private ServerConnector()throws RemoteException, NotBoundException, MalformedURLException {
        talkToFactory = (TalkToFactory) Naming.lookup("rmi://localhost:5050/TalkToServer");
    }

    public static ServerConnector getServerConnector() throws RemoteException, NotBoundException, MalformedURLException {
        if (serverConnector == null){
            serverConnector = new ServerConnector();
        }
        return serverConnector;
    }

    public UserController getUserController() throws RemoteException {
        if (userController == null){
            userController = talkToFactory.getUserController();
        }
        return userController;
    }

    public ChatController getChatController() throws RemoteException {
        if (chatController == null){
            chatController = talkToFactory.getChatController();
        }
        return chatController;
    }
}
