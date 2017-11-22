package com.chamodshehanka.talktoClient.obeservarImpl;

import com.chamodshehanka.talktoClient.ui.controller.ChatWindowUIController;
import com.chamodshehanka.talktoCommon.observer.ChatObserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author chamodshehanka on 11/22/2017
 * @project TalkToGroupChat
 **/
public class ChatObserverImpl extends UnicastRemoteObject implements ChatObserver{

    private ChatWindowUIController chatWindowUI;

    public ChatObserverImpl(ChatWindowUIController chatWindowUI) throws RemoteException {
        this.chatWindowUI = chatWindowUI;
    }

    @Override
    public void update(String message) throws RemoteException {
        chatWindowUI.updateMessage(message);
    }

}
