package com.chamodshehanka.talktoServer.controllerImpl;

import com.chamodshehanka.talktoCommon.controller.ChatController;
import com.chamodshehanka.talktoCommon.controller.TalkToFactory;
import com.chamodshehanka.talktoCommon.controller.UserController;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author chamodshehanka on 11/19/2017
 * @project TalkToGroupChat
 **/
public class TalkToFactoryImpl extends UnicastRemoteObject implements TalkToFactory{

    public TalkToFactoryImpl() throws RemoteException {
    }

    @Override
    public UserController getUserController() throws RemoteException {
        return new UserControllerImpl();
    }

    @Override
    public ChatController getChatController() throws RemoteException {
        return new ChatControllerImpl();
    }
}
