package com.chamodshehanka.talktoCommon.controller;

import com.chamodshehanka.talktoCommon.model.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * @author chamodshehanka on 11/19/2017
 * @project TalkToGroupChat
 **/
public interface UserController extends Remote{
    public boolean addUser(User user)throws ClassNotFoundException,SQLException,RemoteException;
    public User searchUser(String userName)throws ClassNotFoundException,SQLException,RemoteException;
}
