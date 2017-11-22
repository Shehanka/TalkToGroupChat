package com.chamodshehanka.talktoServer.dbAccess;

import com.chamodshehanka.talktoCommon.model.User;
import com.chamodshehanka.talktoServer.db.DBConnection;

import java.rmi.RemoteException;
import java.sql.*;

/**
 * @author chamodshehanka on 11/19/2017
 * @project TalkToGroupChat
 **/
public class UserDBAccess {

    public boolean addUser(User user)throws ClassNotFoundException,SQLException,RemoteException{
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users VALUES (?,?)");
        preparedStatement.setObject(1,user.getUserName());
        preparedStatement.setObject(2,user.getPassword());
        return preparedStatement.executeUpdate() > 0;
    }

    public User searchUser(String userName)throws ClassNotFoundException,SQLException,RemoteException{
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE userName='"+userName+"'");
        return resultSet.next() ? new User(
                resultSet.getString(1),
                resultSet.getString(2)
        ) : null;
    }
}
