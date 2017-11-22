package com.chamodshehanka.talktoServer.observable;

import com.chamodshehanka.talktoCommon.observer.ChatObserver;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author chamodshehanka on 11/22/2017
 * @project TalkToGroupChat
 **/
public class ChatObservable {
    private ArrayList<ChatObserver> chatObserverArrayList = new ArrayList<>();

    public boolean addChatObserver(ChatObserver chatObserver){
        return chatObserverArrayList.add(chatObserver);
    }

    public boolean removeChatObserver(ChatObserver chatObserver){
        return chatObserverArrayList.remove(chatObserver);
    }

    public void notifyObservers(String message) throws RemoteException {
        for (ChatObserver chatObserver:
             chatObserverArrayList) {
            chatObserver.update(message);
        }
    }
}
