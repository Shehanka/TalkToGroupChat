package com.chamodshehanka.talktoCommon.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author chamodshehanka on 11/19/2017
 * @project TalkToGroupChat
 **/
public interface TalkToFactory extends Remote{
    public UserController getUserController()throws RemoteException;
    public ChatController getChatController()throws RemoteException;
}
