package com.example.project;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

<<<<<<< HEAD
    public static final int width = 1280;
    public static final int height = 720;
=======
    public static final int width = 800;
    public static final int height = 600;
>>>>>>> bf24e76eb9f35293e9b425d1bd6f6e1264fcafe7
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage.setTitle("Ping pong");
        Scene scene = new Scene(root, width, height);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }


}