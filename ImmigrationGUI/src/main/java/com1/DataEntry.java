package com1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DataEntry extends Application {

    private Stage stage; // Reference to the stage

    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage; // Store the stage reference
        primaryStage.setTitle("Data Entry");
        setupUI(primaryStage);
        primaryStage.show();

    }

    // Method to setup UI elements
    private void setupUI(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Data Entry");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label firstName = new Label("First Name of petitioner:");
        grid.add(firstName, 0, 1);

        TextField firstNameTextField = new TextField();
        grid.add(firstNameTextField, 1, 1);

        Label lastName = new Label("Last Name of petitioner:");
        grid.add(lastName, 0, 2);

        TextField lastNameTextField = new TextField();
        grid.add(lastNameTextField, 1, 2);

        Label firstNameDependentLabel = new Label("First Name of Dependent:");
        grid.add(firstNameDependentLabel, 0, 3);

        TextField firstNameDependentTextField = new TextField();
        grid.add(firstNameDependentTextField, 1, 3);

        Label lastNameDependentLabel = new Label("Last Name of Dependent:");
        grid.add(lastNameDependentLabel, 0, 4);

        TextField lastNameDependentTextField = new TextField();
        grid.add(lastNameDependentTextField, 1, 4);

        Label dob = new Label("Date of Birth:");
        grid.add(dob, 0, 5);

        TextField dobTextField = new TextField();
        grid.add(dobTextField, 1, 5);

        Label gender = new Label("Gender:");
        grid.add(gender, 0, 6);

        ComboBox<String> genderComboBox = new ComboBox<>();
        genderComboBox.getItems().addAll("Male", "Female", "Other");
        grid.add(genderComboBox, 1, 6);

        Label nationality = new Label("Nationality:");
        grid.add(nationality, 0, 7);

        TextField nationalityTextField = new TextField();
        grid.add(nationalityTextField, 1, 7);

        Label address = new Label("Address:");
        grid.add(address, 0, 8);

        TextField addressTextField = new TextField();
        grid.add(addressTextField, 1, 8);

        Label phoneNumber = new Label("Phone Number:");
        grid.add(phoneNumber, 0, 9);

        TextField phoneNumberTextField = new TextField();
        grid.add(phoneNumberTextField, 1, 9);

        Label email = new Label("Email:");
        grid.add(email, 0, 10);

        TextField emailTextField = new TextField();
        grid.add(emailTextField, 1, 10);

        Label patientType = new Label("Patient Type:");
        grid.add(patientType, 0, 11);

        ComboBox<String> dependentComboBox = new ComboBox<>();
        dependentComboBox.getItems().addAll("Fiance", "Children", "Fiancee");
        grid.add(dependentComboBox, 1, 11);

        Label visaIDLabel = new Label("Visa ID:");
        grid.add(visaIDLabel, 0, 12);

        TextField visaIDTextField = new TextField();
        grid.add(visaIDTextField, 1, 12);

        Button btn = new Button("Submit");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 13);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 0, 14);
        grid.setColumnSpan(actiontarget, 2);
        actiontarget.setFill(Color.FIREBRICK);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // Retrieve values from UI elements
                String firstName = firstNameTextField.getText();
                String lastName = lastNameTextField.getText();
                String firstNameDependent = firstNameDependentTextField.getText();
                String lastNameDependent = lastNameDependentTextField.getText();
                String dob = dobTextField.getText();
                String selectedGender = genderComboBox.getValue();
                String nationality = nationalityTextField.getText();
                String address = addressTextField.getText();
                String phoneNumber = phoneNumberTextField.getText();
                String email = emailTextField.getText();
                String dependent = dependentComboBox.getValue();
                int visaID = Integer.parseInt(visaIDTextField.getText());

                // Validate if all fields are filled
                if (firstName.isEmpty() || lastName.isEmpty() || dob.isEmpty() || selectedGender == null ||
                        nationality.isEmpty() || address.isEmpty() || phoneNumber.isEmpty() || email.isEmpty() ||
                        dependent == null || firstNameDependent.isEmpty() || lastNameDependent.isEmpty()) {
                    actiontarget.setText("Please fill in all fields!");
                } else {
                    // Create a new Immigrant object
                    Immigrant immigrant = new Immigrant(firstName, lastName, dob, selectedGender, nationality,
                            address, phoneNumber, email, dependent, firstNameDependent, lastNameDependent, visaID);

                    // Add the immigrant to the immigrantList
                    ApplicationDriver.immigrantList.add(immigrant);

                    // Clear text fields and combo boxes for a new entry
                    clearFields();

                    // Notify user of successful data entry
                    actiontarget.setText("Immigrant added successfully!");

                    // Print immigrant details

                }
            }

            // Method to clear text fields and combo boxes
            private void clearFields() {
                firstNameTextField.clear();
                lastNameTextField.clear();
                dobTextField.clear();
                genderComboBox.getSelectionModel().clearSelection();
                nationalityTextField.clear();
                addressTextField.clear();
                phoneNumberTextField.clear();
                emailTextField.clear();
                dependentComboBox.getSelectionModel().clearSelection();
                firstNameDependentTextField.clear();
                lastNameDependentTextField.clear();
                visaIDTextField.clear();
            }
        });

        Scene scene = new Scene(grid, 400, 550);
        primaryStage.setScene(scene);
    }
}
