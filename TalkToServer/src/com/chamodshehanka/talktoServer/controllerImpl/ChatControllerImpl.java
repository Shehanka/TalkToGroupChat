package com.chamodshehanka.talktoServer.controllerImpl;

import com.chamodshehanka.talktoCommon.controller.ChatController;
import com.chamodshehanka.talktoCommon.observer.ChatObserver;
import com.chamodshehanka.talktoServer.observable.ChatObservable;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author chamodshehanka on 11/22/2017
 * @project TalkToGroupChat
 **/
public class ChatControllerImpl extends UnicastRemoteObject implements ChatController{

    private final ChatObservable chatObservable = new ChatObservable();

    public ChatControllerImpl() throws RemoteException {
    }

    @Override
    public boolean addChatObserver(ChatObserver chatObserver) throws RemoteException {
        return chatObservable.addChatObserver(chatObserver);
    }

    @Override
    public boolean remoteChatObserver(ChatObserver chatObserver) throws RemoteException {
        return chatObservable.removeChatObserver(chatObserver);
    }

    @Override
    public void sendMessage(String message) throws RemoteException {
        chatObservable.notifyObservers(message);
    }
}
