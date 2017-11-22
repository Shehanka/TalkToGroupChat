package com.chamodshehanka.talktoClient.ui.controller;

import com.chamodshehanka.talktoClient.connector.ServerConnector;
import com.chamodshehanka.talktoCommon.controller.UserController;
import com.chamodshehanka.talktoCommon.model.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * @author chamodshehanka on 11/19/2017
 * @project TalkToGroupChat
 **/
public class LoginFormController implements Initializable{

    @FXML
    public AnchorPane rootLoginForm;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXButton btnLogin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUnlockButtonGraphic();
    }

    @FXML
    private void signIn(){
        String userName = txtUserName.getText();
        String password = txtPassword.getText();

        try {
            UserController userController = ServerConnector.getServerConnector().getUserController();
            User user = userController.searchUser(userName);
            if (user != null){
                if (Objects.equals(user.getUserName(), userName) && Objects.equals(user.getPassword(), password)) {
                    Image image = new Image("/com/chamodshehanka/talktoClient/ui/images/unlock.png");
                    Notifications notifications = Notifications.create()
                            .title("Login")
                            .text(user.getUserName() + ", You've been successfully logged to TalkTo")
                            .graphic(new ImageView(image))
                            .hideAfter(Duration.seconds(5))
                            .position(Pos.BOTTOM_RIGHT);
                    notifications.showConfirm();

                    try {
                        AnchorPane chatWindow = FXMLLoader.load(getClass().getResource(
                                "/com/chamodshehanka/talktoClient/ui/fxml/ChatWindowUI.fxml"
                        ));
                        rootLoginForm.getChildren().setAll(chatWindow);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }else {
                Image image = new Image("/com/chamodshehanka/talktoClient/ui/images/unlock.png");
                Notifications notifications = Notifications.create()
                        .title("Login")
                        .text("Login Failed")
                        .graphic(new ImageView(image))
                        .hideAfter(Duration.seconds(5))
                        .position(Pos.BOTTOM_RIGHT);
                notifications.showError();
            }
        } catch (RemoteException | NotBoundException | MalformedURLException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setUnlockButtonGraphic(){
        final ImageView imgVwUnlock = new ImageView(
                new Image("/com/chamodshehanka/talktoClient/ui/images/unlock.png")
        );
        imgVwUnlock.setFitHeight(20);
        imgVwUnlock.setFitWidth(20);
        btnLogin.setGraphic(imgVwUnlock);
        btnLogin.setContentDisplay(ContentDisplay.CENTER);
    }
}
