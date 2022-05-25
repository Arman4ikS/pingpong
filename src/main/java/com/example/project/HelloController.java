package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.AccessibleAction;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;


public class HelloController {
    @FXML
    Button leftButton, rightButton;

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
    }
}

