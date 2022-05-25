package com.example.project;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;


public class HelloController {
    @FXML
    Button leftButton, rightButton, startGame, ball;
    @FXML
    Label leftWin, rightWin, leftScore, rightScore;
    boolean gameStarted = false;
    int rightCount=0, leftCount=0;
    double ballXSpeed, ballYSpeed;
    public void startGameButton() {
        leftButton.setLayoutY(260);
        rightButton.setLayoutY(260);
        ballXSpeed = 1.0;
        ballYSpeed = 1.0;
        ball.setLayoutY(350);
        ball.setLayoutX(630);
        rightWin.setText("");
        leftWin.setText("");
        startGame.setVisible(false);
        gameStarted = true;
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(8), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (gameStarted) {
                    ball.setLayoutX(ball.getLayoutX() + ballXSpeed);
                    ball.setLayoutY(ball.getLayoutY() + ballYSpeed);
                }
                if ((ball.getLayoutX() == 1206.0) & (ball.getLayoutY() - rightButton.getLayoutY() > -19) & (ball.getLayoutY() - rightButton.getLayoutY() < 200)) {
                    ballXSpeed = -ballXSpeed;
                }
                if ((ball.getLayoutX() == 54.0) & (ball.getLayoutY() - leftButton.getLayoutY() > -19) & (ball.getLayoutY() - leftButton.getLayoutY() < 200)) {
                    ballXSpeed = -ballXSpeed;
                }
                if (ball.getLayoutX() == 0) {
                    ball.setLayoutX(0.1);
                    rightCount += 1;
                    rightScore.setText(Integer.toString(rightCount));
                    rightWin.setText("Победил игрок справа!");
                    startGame.setVisible(true);
                    gameStarted = false;
                }
                if (ball.getLayoutY() <= 0) {
                    ballYSpeed = -ballYSpeed;
                }
                if (ball.getLayoutY() >= 700) {
                    ballYSpeed = -ballYSpeed;
                }
                if (ball.getLayoutX() == 1260) {
                    ball.setLayoutX(1259.9);
                    leftCount += 1;
                    leftScore.setText(Integer.toString(leftCount));
                    leftWin.setText("Победил игрок слева!");
                    startGame.setVisible(true);
                    gameStarted = false;

                }
            }
        }, new javafx.animation.KeyValue[]{}));
        timeline.pause();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void AnchorKeyOne(KeyEvent keyEvent) {
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
        }
    }

    @FXML
    Button leftButton2, rightButton2, startGame2, ball2;
    @FXML
    Label leftWin2, rightWin2, leftScore2, rightScore2;
    boolean gameStarted2 = false;
    int rightCount2=0, leftCount2=0;
    double ball2XSpeed, ball2YSpeed;
    public void startGameButton2() {
        leftButton2.setLayoutY(260);
        rightButton2.setLayoutY(260);
        ball2XSpeed = 1.0;
        ball2YSpeed = 1.0;
        ball2.setLayoutY(350);
        ball2.setLayoutX(630);
        rightWin2.setText("");
        leftWin2.setText("");
        startGame2.setVisible(false);
        gameStarted2 = true;
        Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(8), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (gameStarted2) {
                    ball2.setLayoutX(ball2.getLayoutX() + ball2XSpeed);
                    ball2.setLayoutY(ball2.getLayoutY() + ball2YSpeed);
                }
                if ((ball2.getLayoutX() == 1206.0) & (ball2.getLayoutY() - rightButton2.getLayoutY() > -19) & (ball2.getLayoutY() - rightButton2.getLayoutY() < 200)) {
                    ball2XSpeed = -ball2XSpeed;
                }
                if ((ball2.getLayoutX() == 54.0) & (ball2.getLayoutY() - leftButton2.getLayoutY() > -19) & (ball2.getLayoutY() - leftButton2.getLayoutY() < 200)) {
                    ball2XSpeed = -ball2XSpeed;
                }
                if (ball2.getLayoutX() == 0) {
                    ball2.setLayoutX(0.1);
                    rightCount2 += 1;
                    rightScore2.setText(Integer.toString(rightCount2));
                    rightWin2.setText("Победил игрок справа!");
                    startGame2.setVisible(true);
                    gameStarted2 = false;
                }
                if (ball2.getLayoutY() <= 0) {
                    ball2YSpeed = -ball2YSpeed;
                }
                if (ball2.getLayoutY() >= 700) {
                    ball2YSpeed = -ball2YSpeed;
                }
                if (ball2.getLayoutX() == 1260) {
                    ball2.setLayoutX(1259.9);
                    leftCount2 += 1;
                    leftScore2.setText(Integer.toString(leftCount2));
                    leftWin2.setText("Победил игрок слева!");
                    startGame2.setVisible(true);
                    gameStarted2 = false;

                }
            }
        }, new javafx.animation.KeyValue[]{}));
        timeline2.pause();
        timeline2.setCycleCount(Timeline.INDEFINITE);
        timeline2.play();
    }

    public void AnchorKey(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case W:
                if (leftButton2.getLayoutY() >= 0) {
                    leftButton2.setLayoutY(leftButton2.getLayoutY() - 10);
                }
                break;
            case S:
                if (leftButton2.getLayoutY() <= 520) {
                    leftButton2.setLayoutY(leftButton2.getLayoutY() + 10);
                }
                break;
            case I:
                if (rightButton2.getLayoutY() >= 0) {
                    rightButton2.setLayoutY(rightButton2.getLayoutY() - 10);
                }
                break;
            case K:
                if (rightButton2.getLayoutY() <= 520) {
                    rightButton2.setLayoutY(rightButton2.getLayoutY() + 10);
                }
                break;
        }
    }
}