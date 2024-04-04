package com1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Approve extends Application {

    private Stage stage; // Reference to the stage

    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage; // Store the stage reference
        primaryStage.setTitle("Approver");
        setupUI(primaryStage);
        primaryStage.show();
    }

    // Method to setup UI elements
    private void setupUI(Stage primaryStage) {

        int size = ApplicationDriver.immigrantList.size();
        size--;

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Approver");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label firstName = new Label("First Name:");
        grid.add(firstName, 0, 1);


        Label firstName1 = new Label(ApplicationDriver.immigrantList.get(size).getFirstName());
        grid.add(firstName1, 1, 1);

        Label lastName = new Label("Last Name:");
        grid.add(lastName, 0, 2);

        Label lastName1 = new Label(ApplicationDriver.immigrantList.get(size).getLastName());
        grid.add(lastName1, 1, 2);

        Label dob = new Label("Date of Birth:");
        grid.add(dob, 0, 3);

        Label dob1 = new Label(ApplicationDriver.immigrantList.get(size).getDob());
        grid.add(dob1, 1, 3);

        Label gender = new Label("Gender:");
        grid.add(gender, 0, 4);

        Label gender1 = new Label(ApplicationDriver.immigrantList.get(size).getGender());
        grid.add(gender1, 1, 4);

        Label nationality = new Label("Nationality:");
        grid.add(nationality, 0, 5);

        Label nationality1 = new Label(ApplicationDriver.immigrantList.get(size).getNationality());
        grid.add(nationality1, 1, 5);

        Label address = new Label("Address:");
        grid.add(address, 0, 6);

        Label address1 = new Label(ApplicationDriver.immigrantList.get(size).getAddress());
        grid.add(address1, 1, 6);

        Label phoneNumber = new Label("Phone Number:");
        grid.add(phoneNumber, 0, 7);

        Label phoneNumber1 = new Label(ApplicationDriver.immigrantList.get(size).getPhoneNumber());
        grid.add(phoneNumber1, 1, 7);

        Label email = new Label("Email:");
        grid.add(email, 0, 8);

        Label email1 = new Label(ApplicationDriver.immigrantList.get(size).getEmail());
        grid.add(email1, 1, 8);

        Label patientType = new Label("Patient Type:");
        grid.add(patientType, 0, 9);

        Label patientType1 = new Label(ApplicationDriver.immigrantList.get(size).getDependent());
        grid.add(patientType1, 1, 9);


        Label state = new Label("ACCESS GRANTED:");
        grid.add(state,0,10);

        Label state1 = new Label(Integer.toString(ApplicationDriver.immigrantList.get(size).getAccessGranted()));
        grid.add(state1,1,10);



        Button btn1 = new Button("APPROVE");
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_LEFT); // Aligning to the bottom left
        hbBtn1.getChildren().add(btn1);
        grid.add(hbBtn1, 0, 11);


        Button btn = new Button("REJECT");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 11);



        // Event handler for the "REJECT" button
        btn.setOnAction(e -> {
            // Put your rejection logic here
            // For example, you can show an alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Rejection");
            alert.setHeaderText(null);
            alert.setContentText("Application rejected! Email Delivered.");
            alert.showAndWait();
        });

        // Event handler for the "APPROVE" button
        btn1.setOnAction(e -> {
            // Put your approval logic here
            // For example, you can show an alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Approval");
            alert.setHeaderText(null);
            alert.setContentText("Application approved! Email Delivered.");
            alert.showAndWait();
        });

        if (ApplicationDriver.immigrantList.get(size).getAccessGranted() == 1){
            ApplicationDriver.immigrantList.get(size).setApproval(0);
        }else {
            ApplicationDriver.immigrantList.get(size).setApproval(1);
        }


        Scene scene = new Scene(grid, 400, 450);
        primaryStage.setScene(scene);
    }
}
