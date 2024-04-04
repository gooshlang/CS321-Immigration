package com1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.LinkedList;

public class Review extends Application {

    private Stage stage;
    private Text actiontarget2;




    @Override
//    public void start(Stage primaryStage) {
//        primaryStage.setTitle("Review");
//
//        // Create buttons
//        Button changeInfoBtn = new Button("Change Info");
//        Button validateUserBtn = new Button("Validate User");
//
//        // Set actions for buttons
//        changeInfoBtn.setOnAction(new ChangeInfoHandler());
//        validateUserBtn.setOnAction(new ValidateUserHandler());
//
//        // Add buttons to VBox
//        VBox vbox = new VBox(10);
//        vbox.setAlignment(Pos.CENTER);
//        vbox.setPadding(new Insets(20));
//        vbox.getChildren().addAll(changeInfoBtn, validateUserBtn);
//
//        // Set the scene
//        Scene scene = new Scene(vbox, 300, 200);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Review");

        // Create buttons
        Button changeInfoBtn = new Button("Change Info");
        Button validateUserBtn = new Button("Validate User");

        // Set actions for buttons
        changeInfoBtn.setOnAction(new ChangeInfoHandler());
        validateUserBtn.setOnAction(new ValidateUserHandler());

        // Add buttons to VBox
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(changeInfoBtn, validateUserBtn);

        // Create a GridPane
        GridPane editFormPane = new GridPane();
        editFormPane.setAlignment(Pos.CENTER);
        editFormPane.setHgap(10);
        editFormPane.setVgap(10);
        editFormPane.setPadding(new Insets(25, 25, 25, 25));

        // Add the Text node
        actiontarget2 = new Text();
        editFormPane.add(actiontarget2, 0, 14);
        editFormPane.setColumnSpan(actiontarget2, 2);
        actiontarget2.setFill(Color.FIREBRICK);

        // Create a VBox to contain both the buttons and the GridPane
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(vbox, editFormPane);

        // Set the scene
        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void changeInfoMaker() {
        Stage approveStage = new Stage();
        ChangeInfo changeInfo = new ChangeInfo();
        // Close the login window
        if (stage != null) {
            stage.close();
        }

        changeInfo.start(approveStage);

        // Set event handler for when data entry window closes
        approveStage.setOnCloseRequest(event -> {
            // Just close the current stage without creating a new instance of Review
            approveStage.close();
        });
    }




    private class ChangeInfoHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            changeInfoMaker();



        }
    }

    private class ValidateUserHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {

            int flag = 0;
            Immigrant tail = ApplicationDriver.immigrantList.getLast();

            LinkedList<Immigrant> immigrationList = ApplicationDriver.immigrantList;

            for (Immigrant immigrant : immigrationList) {
                if(immigrant == ApplicationDriver.immigrantList.getLast())
                    break;
                if(immigrant.getVisaID() == tail.getVisaID()){
                    actiontarget2.setText("ACCESS NOT GRANTED!");
                    flag = 1;
                    break;
                }
            }

            if(flag == 0){
                actiontarget2.setText("ACCESS GRANTED!");
            }


        }
    }




}
