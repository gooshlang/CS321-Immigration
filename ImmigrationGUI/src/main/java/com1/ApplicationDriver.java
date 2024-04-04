package com1;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.LinkedList;

public class ApplicationDriver extends Application {

    private Login login;
    private DataEntry dataEntry;

    static public LinkedList<Immigrant> immigrantList = new LinkedList<>();

    @Override
    public void start(Stage primaryStage) {
        // Initialize Login and DataEntry instances
        login = new Login(this);
        dataEntry = new DataEntry();

        // Start with the login page
        login.start(primaryStage);
    }

    // Method to handle successful login for data entry
    public void handleSuccessfulLoginDataEntry() {
        Stage dataEntryStage = new Stage();
        // Close the login window
        login.stop();
        // Open the data entry window
        dataEntry.start(dataEntryStage);

        // Set event handler for when data entry window closes
        dataEntryStage.setOnCloseRequest(event -> {
            // Open the login window again
            startLoginPage();
        });
    }

    // Method to handle successful login for review
    public void handleSuccessfulLoginReview() {
        Stage reviewStage = new Stage();
        // Close the login window
        login.stop();
        // Open the data entry window
        dataEntry.start(reviewStage);

        // Set event handler for when data entry window closes
        reviewStage.setOnCloseRequest(event -> {
            // Open the login window again
            startLoginPage();
        });
    }

    // Method to handle successful login for approval
    public void handleSuccessfulLoginApprove() {
        Stage approveStage = new Stage();
        // Close the login window
        login.stop();
        // Open the data entry window
        dataEntry.start(approveStage);

        // Set event handler for when data entry window closes
        approveStage.setOnCloseRequest(event -> {
            // Open the login window again
            startLoginPage();
        });
    }

    // Method to start the login page
    private void startLoginPage() {
        Stage loginStage = new Stage();
        login.start(loginStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
