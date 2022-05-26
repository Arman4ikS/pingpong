package com.example.project;

import javafx.scene.input.KeyCode;



public class TwoPlayersController extends AbstractGameController{

    private boolean isGoingUpPlayerTwo = false;
    private boolean isGoingDownPlayerTwo = false;
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
            case O:
                isGoingUpPlayerTwo = true;
                isGoingDownPlayerTwo = false;
                break;
            case L:
                isGoingDownPlayerTwo = true;
                isGoingUpPlayerTwo = false;
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
            case O:
                isGoingUpPlayerTwo = false;
                break;
            case L:
                isGoingDownPlayerTwo = false;
                break;
        }
    }

    @Override
    protected void movePlayers(){
        if ((isGoingUpPlayerOne)&&(playerOneYPos > 0)) playerOneYPos -= PLAYERS_SPEED;
        if ((isGoingDownPlayerOne)&&(playerOneYPos + PLAYER_HEIGHT < PingPongApplication.HEIGHT)) playerOneYPos += PLAYERS_SPEED;
        if ((isGoingUpPlayerTwo)&&(playerTwoYPos > 0)) playerTwoYPos -= PLAYERS_SPEED;
        if ((isGoingDownPlayerTwo)&&(playerTwoYPos + PLAYER_HEIGHT < PingPongApplication.HEIGHT)) playerTwoYPos += PLAYERS_SPEED;
    }

    @Override
    protected void additionalActionsOnFrame() {
        // DO nothing
    }
}
