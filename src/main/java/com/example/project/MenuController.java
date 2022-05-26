package com.example.project;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;
public class MenuController {
    @FXML
    Button startButton1P;
    @FXML
    Button startButton2P;

    public void start1P() throws Exception{
        Stage stage = (Stage) startButton1P.getScene().getWindow();
        new OnePlayerController().start(stage);
    }
    public void start2P() throws Exception{
        Stage stage = (Stage) startButton2P.getScene().getWindow();
        new TwoPlayersController().start(stage);
    }

}

