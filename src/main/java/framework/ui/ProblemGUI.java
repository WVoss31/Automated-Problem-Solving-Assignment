/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package framework.ui;

import domains.farmer.FarmerProblem;
import domains.farmer.FarmerState;
import domains.farmer.FarmerMover;
import framework.problem.Problem;
import framework.problem.State;
import framework.solution.SolvingAssistant;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Button;



/**
 *
 * @author walker
 */
public class ProblemGUI extends VBox {
    public ProblemGUI(Problem problem, double width, double height) {
        //sets VBox size to the width and height
        super.setPrefSize(width, height);
        super.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        super.setPadding(new Insets(10));
        super.setSpacing(10);
        super.setAlignment(Pos.CENTER);
        //creating a label and setting font for welcome msg
        Label Welcome = new Label(new FarmerProblem().getName());
        Welcome.setWrapText(true);
        Welcome.setFont(Font.font("JetBrainsMono Nerd Font Mono",FontWeight.BOLD, 24));
        //creating a label for intro
        Label IntroLabel = new Label(new FarmerProblem().getIntroduction());
        IntroLabel.setWrapText(true);
        IntroLabel.setFont(Font.font("JetBrainsMono Nerd Font Mono", 12));
        //making new HBox
        HBox displayHBox = new HBox(50);
        displayHBox.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        displayHBox.setAlignment(Pos.CENTER);
        
        displayState(new FarmerState("West", "West", "West", "West"), displayHBox, "Current State:");
        displayButtons(displayHBox, "Moves (0 so far):");
        displayState(new FarmerState("East", "East", "East", "East"), displayHBox, "Goal State:");
 
        //adding to display
        super.getChildren().addAll(Welcome, IntroLabel, displayHBox);
    }
    
    public ProblemGUI(Problem problem) {
        this(problem, 600, 600);
    }
    
    
    /**
     * 
     * @param state
     * @param box
     * @param labelString 
     */
    private void displayState(FarmerState state, HBox box, String labelString) {
        VBox verticalBox = new VBox();
        HBox hb = new HBox();
        //creating title label
        Label titLabel = new Label(labelString);
        titLabel.setFont(Font.font("JetBrainsMono Nerd Font Mono",FontWeight.BOLD, 20));
        //creating state diagram
        Label nodeLabel = new Label(state.toString());
        nodeLabel.setBorder(new Border(new BorderStroke(Paint.valueOf("Black"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        nodeLabel.setFont(Font.font("JetBrainsMono Nerd Font Mono",FontWeight.BOLD, 20));
        //setting padding stuff
        verticalBox.setSpacing(10);
        titLabel.setAlignment(Pos.CENTER);
        //I know what you are wondering: "did you really create an HBox 
        //and add nodeLabel to it just so it is horizonally center?"
        //and the answer is yes, yes I did, yes, I know I could probably use
        //a GridPane, but I am sick of trying to get it to work and display,
        //so this is how I will do this -_-
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().add(nodeLabel);
        //adding to display
        verticalBox.getChildren().addAll(titLabel, hb);
        box.getChildren().addAll(verticalBox);
    }
    
    /**
     * 
     * @param box
     * @param labelString 
     */
    private void displayButtons(HBox box, String labelString) {
        //creating boxes
        VBox verticalBox = new VBox();
        verticalBox.setSpacing(10);
        HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER);
        //setting up label
        Label title = new Label(labelString);
        title.setFont(Font.font("JetBrainsMono Nerd Font Mono",FontWeight.BOLD, 20));
        //adding title to center
        hb.getChildren().add(title);
        //adding center title to vbox
        verticalBox.getChildren().addAll(hb);
        //adding buttons to vbox
        for (String moves : new FarmerMover().getMoveNames()) {
            Button move = new Button(moves);
            move.setPrefSize(250, 15);
            verticalBox.getChildren().add(move);
        }   
        //adding buttons to display
        box.getChildren().add(verticalBox);
    }

}
