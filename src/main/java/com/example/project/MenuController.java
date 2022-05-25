package com.example.project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class MenuController {
    @FXML
    Button startButton1P;
    @FXML
    Button startButton2P;

    public void start1P() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("OnePlayer.fxml"));
        Stage window = (Stage) startButton1P.getScene().getWindow();
        window.setScene(new Scene(root, HelloApplication.width, HelloApplication.height));
    }
    public void start2P() throws Exception{

    }

}

