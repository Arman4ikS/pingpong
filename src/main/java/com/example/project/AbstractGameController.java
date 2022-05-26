package com.example.project;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public abstract class AbstractGameController {

    //variable
    protected static final int PLAYER_HEIGHT = 100;
    private static final int PLAYER_WIDTH = 15;
    private static final double BALL_R = 15;
    private static final int CHANGE_SPEED_DELAY = 100;
    protected static final int PLAYERS_SPEED = 7;

    private int ballYSpeed = 3;
    private int ballXSpeed = 3;
    protected double playerOneYPos = PingPongApplication.HEIGHT / 2;
    protected double playerTwoYPos = PingPongApplication.HEIGHT / 2;
    private int playerOneXPos = 10;
    private double playerTwoXPos = PingPongApplication.WIDTH - PLAYER_WIDTH - playerOneXPos;
    private double ballXPos = PingPongApplication.WIDTH / 2;
    protected double ballYPos = PingPongApplication.HEIGHT / 2;
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    protected boolean gameStarted;
    protected boolean isGoingUpPlayerOne = false;
    protected boolean isGoingDownPlayerOne = false;
    private long changeSpeedDelayStartTime = 0;
    private boolean oneWin = false;
    private boolean twoWin = false;

    abstract void handleKeyPressed(KeyCode keyCode);
    abstract void handleKeyReleased(KeyCode keyCode);
    protected abstract void additionalActionsOnFrame();

    public void start(Stage stage) throws Exception {
        stage.setTitle("P O G C H A M P");
        //background size
        Canvas canvas = new Canvas(PingPongApplication.WIDTH, PingPongApplication.HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //JavaFX Timeline = free form animation defined by KeyFrames and their duration
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> run(gc, canvas)));
        //number of cycles in animation INDEFINITE = repeat indefinitely
        tl.setCycleCount(Timeline.INDEFINITE);

        canvas.setOnMouseClicked(e ->  gameStarted = true);
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                handleKeyPressed(ke.getCode());
            }
        });
        stage.getScene().setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                handleKeyReleased(ke.getCode());
            }
        });
        stage.show();
        tl.play();
    }

    protected void movePlayers(){
        if ((isGoingUpPlayerOne)&&(playerOneYPos > 0)) playerOneYPos -= PLAYERS_SPEED;
        if ((isGoingDownPlayerOne)&&(playerOneYPos + PLAYER_HEIGHT < PingPongApplication.HEIGHT)) playerOneYPos += PLAYERS_SPEED;
    }

    private void run(GraphicsContext gc, Canvas canvas) {
        //set graphics
        //set background color
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, PingPongApplication.WIDTH, PingPongApplication.HEIGHT);

        movePlayers();

        //set text
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font(30));

        if(gameStarted) {

            //set ball movement
            ballXPos+=ballXSpeed;
            ballYPos+=ballYSpeed;

            oneWin = twoWin = false;
            additionalActionsOnFrame();

            //draw the ball
            gc.fillOval(ballXPos, ballYPos, BALL_R, BALL_R);

        } else {
            //set the start text
            gc.setStroke(Color.WHITE);
            gc.setTextAlign(TextAlignment.CENTER);

            if (oneWin){
                gc.strokeText("Click", PingPongApplication.WIDTH / 4, PingPongApplication.HEIGHT / 2);
                gc.strokeText("Player ONE wins", PingPongApplication.WIDTH / 4, PingPongApplication.HEIGHT / 4 * 3);
            } else if (twoWin){
                gc.strokeText("Player TWO wins", PingPongApplication.WIDTH / 4 * 3, PingPongApplication.HEIGHT / 4 * 3);
                gc.strokeText("Click", PingPongApplication.WIDTH / 4 * 3, PingPongApplication.HEIGHT / 2);
            } else
                gc.strokeText("Click", PingPongApplication.WIDTH / 4, PingPongApplication.HEIGHT / 2);

            //reset the ball start position
            ballXPos = PingPongApplication.WIDTH / 2;
            ballYPos = PingPongApplication.HEIGHT / 2;

            //reset the ball speed and the direction
            ballXSpeed = new Random().nextInt(2) == 0 ? 3: -3;
            ballYSpeed = new Random().nextInt(2) == 0 ? 3: -3;
        }

        //makes sure the ball stays in the canvas
        if(ballYPos+BALL_R+20 > PingPongApplication.HEIGHT || ballYPos < 25) ballYSpeed *=-1;

        //if you miss the ball, computer gets a point
        if(ballXPos < playerOneXPos - PLAYER_WIDTH) {
            playerTwoScore++;
            twoWin = true;
            gameStarted = false;
        }

        //if the computer misses the ball, you get a point
        if(ballXPos > playerTwoXPos + PLAYER_WIDTH) {
            playerOneScore++;
            oneWin = true;
            gameStarted = false;
        }

        //increase the speed after the ball hits the player
        boolean firstPlayerHitTheBall =(ballXPos < playerOneXPos + PLAYER_WIDTH) && ballYPos >= playerOneYPos && ballYPos <= playerOneYPos + PLAYER_HEIGHT;
        boolean secondPlayerHitTheBall = (ballXPos + BALL_R > playerTwoXPos) && ballYPos >= playerTwoYPos && ballYPos <= playerTwoYPos + PLAYER_HEIGHT;
        boolean speedChangeDelayIsFinished = changeSpeedDelayStartTime+ CHANGE_SPEED_DELAY <System.currentTimeMillis();

        if(speedChangeDelayIsFinished && (firstPlayerHitTheBall || secondPlayerHitTheBall)) {
            ballYSpeed += 1 * Math.signum(ballYSpeed);
            ballXSpeed += 1 * Math.signum(ballXSpeed);
            ballXSpeed *= -1;
            ballYSpeed *= 1;
            changeSpeedDelayStartTime = System.currentTimeMillis();
        }

        //draw score
        gc.fillText(playerOneScore + "\t\t\t\t\t\t\t\t" + playerTwoScore, PingPongApplication.WIDTH / 2, 100);
        //draw player 1 & 2
        gc.fillRect(playerTwoXPos, playerTwoYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
        gc.fillRect(playerOneXPos, playerOneYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
        gc.fillRect(35, 10, PingPongApplication.WIDTH -70, 10);
        gc.fillRect(35, PingPongApplication.HEIGHT -20, PingPongApplication.WIDTH -70, 10);

        int j = 10;
        for (int i = 0; j < PingPongApplication.HEIGHT -20; i++){
            gc.fillRect(PingPongApplication.WIDTH /2, j, 10, 10);
            j+= 30;
        }
    }
}