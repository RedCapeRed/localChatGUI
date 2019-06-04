package main;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {

    private double xOffset = 0;
    private double yOffset = 0;

    public void create() throws IOException {

        Stage stage = new Stage();
        FXMLLoader autoLoader = new FXMLLoader();
        autoLoader.setLocation(getClass().getClassLoader().getResource("fxml/AuthorizationWindow.fxml"));
        Parent autoRoot = autoLoader.load();
        Const.authorizationController = autoLoader.getController();
        stage.setScene(new Scene(autoRoot));
        stage.initStyle(StageStyle.TRANSPARENT);
        Scenes.autoStage = stage;
        Scenes.autoStage.setResizable(false);
        Scenes.autoStage.getScene().setFill(Color.TRANSPARENT);
        autoRoot.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        autoRoot.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Scenes.autoStage.setX(event.getScreenX() - xOffset);
                Scenes.autoStage.setY(event.getScreenY() - yOffset);
            }
        });

        stage = new Stage();
        FXMLLoader mainLoader = new FXMLLoader();
        mainLoader.setLocation(getClass().getClassLoader().getResource("fxml/MainWindow.fxml"));
        Parent mainRoot = mainLoader.load();
        Const.mainController = mainLoader.getController();
        stage.setScene(new Scene(mainRoot));
        stage.initStyle(StageStyle.TRANSPARENT);
        Scenes.mainStage = stage;
        Scenes.mainStage.setResizable(false);
        Scenes.mainStage.getScene().setFill(Color.TRANSPARENT);

        mainRoot.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        mainRoot.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Scenes.mainStage.setX(event.getScreenX() - xOffset);
                Scenes.mainStage.setY(event.getScreenY() - yOffset);
            }
        });





    }
    @Override
    public void start(final Stage primaryStage) throws Exception{
        create();
        Scenes.autoStage.show();
        //Scenes.mainStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
