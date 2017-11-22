package com.chamodshehanka.talktoCommon.controller;

import com.chamodshehanka.talktoCommon.observer.ChatObserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author chamodshehanka on 11/22/2017
 * @project TalkToGroupChat
 **/
public interface ChatController extends Remote{
    public boolean addChatObserver(ChatObserver chatObserver)throws RemoteException;
    public boolean remoteChatObserver(ChatObserver chatObserver)throws RemoteException;
    public void sendMessage(String message)throws RemoteException;
}
