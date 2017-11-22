package com.chamodshehanka.talktoCommon.observer;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author chamodshehanka on 11/22/2017
 * @project TalkToGroupChat
 **/
public interface ChatObserver extends Remote {
    public void update(String message)throws RemoteException;
}
