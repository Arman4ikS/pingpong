package com.example.project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;


public class HelloController {
    @FXML
    Button leftButton, rightButton;
    @FXML
    Button startButton;
    @FXML
    Circle circle;
    double lbutton;
    double rbutton;

    public void start(MouseEvent mouseEvent) {
        startButton.setVisible(false);
    }

    public void left1(MouseEvent mouseEvent) {
        lbutton = mouseEvent.getY();
        leftButton.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                leftButton.setLayoutY(mouseEvent.getSceneY() - lbutton);

            }
        });
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

