package com.example.project;

import javafx.scene.input.KeyCode;

public class OnePlayerController extends AbstractGameController{

    @Override
    void handleKeyPressed(KeyCode keyCode) {
        switch (keyCode){
            case W:
                isGoingUpPlayerOne = true;
                isGoingDownPlayerOne = false;
                break;
            case S:
                isGoingDownPlayerOne = true;
                isGoingUpPlayerOne = false;
                break;
            case SPACE:
                gameStarted = true;
                break;
        }
    }

    @Override
    void handleKeyReleased(KeyCode keyCode) {
        switch (keyCode){
            case W:
                isGoingUpPlayerOne = false;
                break;
            case S:
                isGoingDownPlayerOne = false;
                break;
        }
    }

    @Override
    protected void additionalActionsOnFrame() {
        if ((ballYPos > 0)&&(ballYPos < PingPongApplication.HEIGHT -PLAYER_HEIGHT)){
            if (ballYPos >= playerTwoYPos) playerTwoYPos+=5;
            if (ballYPos < playerTwoYPos) playerTwoYPos-=5;
        }
    }
}
