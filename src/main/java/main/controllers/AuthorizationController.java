package main.controllers;

import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class AuthorizationController {

    @FXML
    private TextField loginFieldSignIn,loginFieldSignUp;

    @FXML
    private PasswordField passwordFieldSignIn,passwordFieldSignUp;

    @FXML
    private Button signInButton,signUpButton,signUpButton1,backButton;

    @FXML
    void initialize() {

    }

    @FXML
    void openSignUp(){
        TranslateTransition tt1 = new TranslateTransition(Duration.millis(400),signUpButton);
        tt1.setByX(410);
        TranslateTransition tt2 = new TranslateTransition(Duration.millis(400),signInButton);
        tt2.setByX(165);
        TranslateTransition tt3 = new TranslateTransition(Duration.millis(400),signUpButton1);
        tt3.setByX(283);
        TranslateTransition tt4 = new TranslateTransition(Duration.millis(400),backButton);
        tt4.setByX(283);
        SequentialTransition sequentialTransition = new SequentialTransition(tt1,tt2,tt3,tt4);
        sequentialTransition.play();

        System.out.println(signUpButton.getLayoutX() + " = Layout X");
    }
    @FXML
    void closeSignUp(){
        TranslateTransition tt1 = new TranslateTransition(Duration.millis(400),signUpButton);
        tt1.setByX(-410);
        TranslateTransition tt2 = new TranslateTransition(Duration.millis(400),signInButton);
        tt2.setByX(-165);
        TranslateTransition tt3 = new TranslateTransition(Duration.millis(400),signUpButton1);
        tt3.setByX(-283);
        TranslateTransition tt4 = new TranslateTransition(Duration.millis(400),backButton);
        tt4.setByX(-283);
        SequentialTransition sequentialTransition = new SequentialTransition(tt4,tt3,tt1,tt2);
        sequentialTransition.play();
    }
}
