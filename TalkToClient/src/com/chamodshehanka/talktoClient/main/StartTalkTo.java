package com.chamodshehanka.talktoClient.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * @author chamodshehanka on 11/18/2017
 * @project TalkToGroupChat
 **/
public class StartTalkTo extends Application{

    public static boolean isSplashLoaded = false;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource(
                "/com/chamodshehanka/talktoClient/ui/fxml/ChatWindowUI.fxml"
        ));
        primaryStage.setTitle("Talk To Group Chat");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/com/chamodshehanka/talktoClient/ui/icon/talkToIcon.png")));
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
