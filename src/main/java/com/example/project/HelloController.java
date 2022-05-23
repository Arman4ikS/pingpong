package com.example.project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.input.KeyEvent;


public class HelloController {
    @FXML
    Button leftButton, rightButton;
    @FXML
    Button startButton;
    @FXML
    Circle circle;
    double lbutton;
    double rbutton;

    boolean player1Up = false;
    boolean player1Down = false;


    public void start(MouseEvent mouseEvent) {
        startButton.setVisible(false);
        Scene scene = leftButton.getScene();
        scene.setOnKeyTyped(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if ((ke.getCharacter().equals("w"))&&(leftButton.getLayoutY()>=0)){
                    leftButton.setLayoutY(leftButton.getLayoutY()-1);
                } else if ((ke.getCharacter().equals("s"))&&(leftButton.getLayoutY()<=HelloApplication.height)){
                    leftButton.setLayoutY(leftButton.getLayoutY()+1);
                }
            }
        });
    }

    public void left1() {
    }

    public void right1(MouseEvent mouseEvent) {
        rbutton = mouseEvent.getY();
        rightButton.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                rightButton.setLayoutY(mouseEvent.getSceneY() - rbutton);

            }
        });
    }
}

