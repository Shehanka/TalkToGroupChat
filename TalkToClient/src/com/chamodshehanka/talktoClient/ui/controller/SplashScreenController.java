package com.chamodshehanka.talktoClient.ui.controller;

import com.chamodshehanka.talktoClient.main.StartTalkTo;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author chamodshehanka on 11/18/2017
 * @project TalkToGroupChat
 **/
public class SplashScreenController implements Initializable{

    @FXML
    private AnchorPane root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (!StartTalkTo.isSplashLoaded){
            try {
                loadSplashScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadSplashScreen()throws IOException{
        StartTalkTo.isSplashLoaded = true;
        AnchorPane splashPane = FXMLLoader.load(getClass().getResource(
                "/com/chamodshehanka/talktoClient/ui/fxml/SplashScreen.fxml"
        ));
        root.getChildren().setAll(splashPane);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3),splashPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.setCycleCount(1);

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(3),splashPane);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setCycleCount(1);

        fadeTransition.play();
        fadeTransition.setOnFinished((e)-> fadeOut.play());

        fadeOut.setOnFinished((e)->{
            try {
                AnchorPane parentPane = FXMLLoader.load(getClass().getResource(
                        "/com/chamodshehanka/talktoClient/ui/fxml/LoginForm.fxml"
                ));
                root.getChildren().setAll(parentPane);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }
}
