package com.chamodshehanka.talktoServer.controllerImpl;

import com.chamodshehanka.talktoCommon.controller.UserController;
import com.chamodshehanka.talktoCommon.model.User;
import com.chamodshehanka.talktoServer.dbAccess.UserDBAccess;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

/**
 * @author chamodshehanka on 11/19/2017
 * @project TalkToGroupChat
 **/
public class UserControllerImpl extends UnicastRemoteObject implements UserController {

    private UserDBAccess userDBAccess = new UserDBAccess();

    public UserControllerImpl() throws RemoteException {
    }

    @Override
    public boolean addUser(User user) throws ClassNotFoundException, SQLException, RemoteException {
        return userDBAccess.addUser(user);
    }

    @Override
    public User searchUser(String userName) throws ClassNotFoundException, SQLException, RemoteException {
        return userDBAccess.searchUser(userName);
    }
}
