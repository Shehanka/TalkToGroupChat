package com.chamodshehanka.talktoServer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author chamodshehanka on 11/19/2017
 * @project TalkToGroupChat
 **/
public class DBConnection {
    public static Connection getConnection()throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/talkto","root","wampwamp");
    }
}
