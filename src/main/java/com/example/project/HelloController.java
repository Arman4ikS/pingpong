package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
<<<<<<< HEAD
import javafx.scene.AccessibleAction;
import javafx.scene.control.Button;
=======
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
>>>>>>> bf24e76eb9f35293e9b425d1bd6f6e1264fcafe7
import javafx.scene.input.KeyEvent;


public class HelloController {
    @FXML
    Button leftButton, rightButton;

<<<<<<< HEAD
    public void AnchorKey(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case W:
                if (leftButton.getLayoutY() >= 0) {
                    leftButton.setLayoutY(leftButton.getLayoutY() - 10);
                }
                break;
            case S:
                if (leftButton.getLayoutY() <= 520) {
                    leftButton.setLayoutY(leftButton.getLayoutY() + 10);
                }
                break;
            case I:
                if (rightButton.getLayoutY() >= 0) {
                    rightButton.setLayoutY(rightButton.getLayoutY() - 10);
                }
                break;
            case K:
                if (rightButton.getLayoutY() <= 520) {
                    rightButton.setLayoutY(rightButton.getLayoutY() + 10);
                }
                break;
        }
=======
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
>>>>>>> bf24e76eb9f35293e9b425d1bd6f6e1264fcafe7
    }
}

