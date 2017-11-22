package com.chamodshehanka.talktoClient.ui.controller;

import com.chamodshehanka.talktoClient.connector.ServerConnector;
import com.chamodshehanka.talktoClient.obeservarImpl.ChatObserverImpl;
import com.chamodshehanka.talktoCommon.controller.ChatController;
import com.chamodshehanka.talktoCommon.observer.ChatObserver;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.ResourceBundle;

/**
 * @author chamodshehanka on 11/21/2017
 * @project TalkToGroupChat
 **/

public class ChatWindowUIController implements Initializable{

    @FXML
    private AnchorPane rootChatWindow;

    @FXML
    private AnchorPane rootChatMessages;

    @FXML
    private AnchorPane rootChatControllers;

    @FXML
    private AnchorPane rootChatFooter;

    @FXML
    private Circle circleIcon;

    @FXML
    private ImageView menuHamburger;

    @FXML
    private TextArea messageTextArea;

    @FXML
    private TextField txtMessage;

    private final ContextMenu contextMenu = new ContextMenu();
    private final MenuItem menuSettings = new MenuItem("Settings");
    private final MenuItem menuLogOut = new MenuItem("Log out");

    private String message = "";
    private ChatObserver chatObserver;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        menuLogOut.setOnAction(event -> {
            try {
                AnchorPane loginPane = FXMLLoader.load(getClass().getResource(
                        "/com/chamodshehanka/talktoClient/ui/fxml/LoginForm.fxml"
                ));
                rootChatWindow.getChildren().setAll(loginPane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        menuSettings.setOnAction(event -> {
            System.out.println("Settings aren't done yet");
            System.out.println();
        });

        contextMenu.getItems().addAll(menuSettings,menuLogOut);
        setGUIUtils();

        try {
            this.chatObserver = new ChatObserverImpl(this);
            ChatController chatController = ServerConnector.getServerConnector().getChatController();
            chatController.addChatObserver(chatObserver);
        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void sendMessageEvent(MouseEvent event) {
        String tempMessage = txtMessage.getText();
        try {
            ChatController chatController = ServerConnector.getServerConnector().getChatController();
            chatController.sendMessage(tempMessage);
            txtMessage.clear();
        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            txtMessage.setText(tempMessage);
            e.printStackTrace();
        }
    }

    @FXML
    private void loadContextMenu(ContextMenuEvent event){
        contextMenu.show(menuHamburger, event.getScreenX(), event.getScreenY());
    }

    private void setGUIUtils(){
        circleIcon.setFill(new ImagePattern(new Image(
                "/com/chamodshehanka/talktoClient/ui/images/ijseLogo.jpg"
        )));
        messageTextArea.setEditable(false);
    }

    public void updateMessage(String message) {
        this.message = message;
        messageTextArea.appendText(message+"\n\n");
//        fileWrite();
    }

    private void fileWrite(){
        ObservableList<CharSequence> msgTextList = messageTextArea.getParagraphs();
        Iterator<CharSequence> iterator = msgTextList.iterator();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(
                    "/com/chamodshehanka/talktoClient/connector/MessageTexts.txt",
                    true
            ));
            writer.write(txtMessage.getText());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
