package com.example.project;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloController extends Application {

    //variable
    private static final int width = 1000;
    private static final int height = 600;
    private static final int PLAYER_HEIGHT = 100;
    private static final int PLAYER_WIDTH = 15;
    private static final double BALL_R = 15;
    private int ballYSpeed = 3;
    private int ballXSpeed = 3;
    private double playerOneYPos = height / 2;
    private double YPos = height / 2;
    private double playerTwoYPos = height / 2;
    private double ballXPos = width / 2;
    private double ballYPos = height / 2;
    private int scoreP1 = 0;
    private int scoreP2 = 0;
    private boolean gameStarted;
    private int playerOneXPos = 10;
    private double playerTwoXPos = width - PLAYER_WIDTH - playerOneXPos;

    public void start(Stage stage) throws Exception {
        stage.setTitle("P O G C H A M P");
        //background size
        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //JavaFX Timeline = free form animation defined by KeyFrames and their duration
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> run(gc, canvas)));
        //number of cycles in animation INDEFINITE = repeat indefinitely
        tl.setCycleCount(Timeline.INDEFINITE);


        canvas.setOnMouseClicked(e ->  gameStarted = true);
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();
        tl.play();
    }

    private void run(GraphicsContext gc, Canvas canvas) {
        //set graphics
        //set background color
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, width, height);

        canvas.setOnMouseMoved(e ->  YPos = e.getY() - PLAYER_HEIGHT/2);
        if ((YPos > 0)&&(YPos  < height- PLAYER_HEIGHT))
            playerOneYPos = YPos;
        //mouse control (move and click)

        //set text
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font(30));

        if(gameStarted) {

            //set ball movement
            ballXPos+=ballXSpeed;
            ballYPos+=ballYSpeed;

            if ((ballYPos > 0)&&(ballYPos < height-PLAYER_HEIGHT)){
                if (ballYPos >= playerTwoYPos) playerTwoYPos+=5;
                if (ballYPos < playerTwoYPos) playerTwoYPos-=5;
            }

            //draw the ball
            gc.fillOval(ballXPos, ballYPos, BALL_R, BALL_R);

        } else {
            //set the start text
            gc.setStroke(Color.WHITE);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.strokeText("Click", width / 4, height / 2);

            //reset the ball start position
            ballXPos = width / 2;
            ballYPos = height / 2;

            //reset the ball speed and the direction
            ballXSpeed = new Random().nextInt(2) == 0 ? 3: -3;
            ballYSpeed = new Random().nextInt(2) == 0 ? 3: -3;
        }

        //makes sure the ball stays in the canvas
        if(ballYPos+BALL_R+20 > height || ballYPos < 25) ballYSpeed *=-1;

        //if you miss the ball, computer gets a point
        if(ballXPos < playerOneXPos - PLAYER_WIDTH) {
            scoreP2++;
            gameStarted = false;
        }

        //if the computer misses the ball, you get a point
        if(ballXPos > playerTwoXPos + PLAYER_WIDTH) {
            scoreP1++;
            gameStarted = false;
        }

        //increase the speed after the ball hits the player
        if( ((ballXPos + BALL_R > playerTwoXPos) && ballYPos >= playerTwoYPos && ballYPos <= playerTwoYPos + PLAYER_HEIGHT) ||
                ((ballXPos < playerOneXPos + PLAYER_WIDTH) && ballYPos >= playerOneYPos && ballYPos <= playerOneYPos + PLAYER_HEIGHT)) {
            ballYSpeed += 1 * Math.signum(ballYSpeed);
            ballXSpeed += 1 * Math.signum(ballXSpeed);
            ballXSpeed *= -1;
            ballYSpeed *= 1;
        }

        //draw score
        gc.fillText(scoreP1 + "\t\t\t\t\t\t\t\t" + scoreP2, width / 2, 100);
        //draw player 1 & 2
        gc.fillRect(playerTwoXPos, playerTwoYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
        gc.fillRect(playerOneXPos, playerOneYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
        gc.fillRect(35, 10, 930, 10);
        gc.fillRect(35, 580, 930, 10);

        int j = 10;
        for (int i = 0; i < 20; i++){
            gc.fillRect(width/2, j, 10, 10);
            j+= 30;
        }
    }

    // start the application
    public static void main(String[] args) {
        launch(args);
    }
}