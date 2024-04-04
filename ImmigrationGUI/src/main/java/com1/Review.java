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
import javafx.scene.layout.StackPane;

public class Review extends Application {

    private Stage stage;

    @Override
    public void start(Stage primaryStage) {

        this.stage = primaryStage; // Store the stage reference
        primaryStage.setTitle("Review");
        setupUI(primaryStage);
        primaryStage.show();

    }

    private void setupUI(Stage primaryStage) {

        Immigrant immigrant = ApplicationDriver.immigrantList.getLast();


        GridPane editFormPane = new GridPane();
        editFormPane.setHgap(10);
        editFormPane.setVgap(5);


        // Add fields of the form to edit

        Text scenetitle = new Text("Review Form");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        editFormPane.add(scenetitle, 0, 0, 2, 1);

        Label firstName = new Label("First Name of petitioner:");
        editFormPane.add(firstName, 0, 1);

        TextField firstNameTextField = new TextField(immigrant.getFirstName());
        editFormPane.add(firstNameTextField, 1, 1);

        Label lastName = new Label("Last Name of petitioner:");
        editFormPane.add(lastName, 0, 2);

        TextField lastNameTextField = new TextField(immigrant.getLastName());
        editFormPane.add(lastNameTextField, 1, 2);

        Label firstNameDependentLabel = new Label("First Name of Dependent:");
        editFormPane.add(firstNameDependentLabel, 0, 3);

        TextField firstNameDependentTextField = new TextField(immigrant.getFirstNameDependent());
        editFormPane.add(firstNameDependentTextField, 1, 3);

        Label lastNameDependentLabel = new Label("Last Name of Dependent:");
        editFormPane.add(lastNameDependentLabel, 0, 4);

        TextField lastNameDependentTextField = new TextField(immigrant.getLastNameDependent());
        editFormPane.add(lastNameDependentTextField, 1, 4);

        Label dob = new Label("Date of Birth:");
        editFormPane.add(dob, 0, 5);

        TextField dobTextField = new TextField(immigrant.getDob());
        editFormPane.add(dobTextField, 1, 5);

        Label gender = new Label("Gender:");
        editFormPane.add(gender, 0, 6);

        TextField gender1 = new TextField(immigrant.getGender());
        editFormPane.add(gender1, 1, 5);

        ComboBox<String> genderComboBox = new ComboBox<>();
        genderComboBox.getItems().addAll("Male", "Female", "Other");
        editFormPane.add(genderComboBox, 1, 6);

        Label nationality = new Label("Nationality:");
        editFormPane.add(nationality, 0, 7);

        TextField nationalityTextField = new TextField(immigrant.getNationality());
        editFormPane.add(nationalityTextField, 1, 7);

        Label address = new Label("Address:");
        editFormPane.add(address, 0, 8);

        TextField addressTextField = new TextField(immigrant.getAddress());
        editFormPane.add(addressTextField, 1, 8);

        Label phoneNumber = new Label("Phone Number:");
        editFormPane.add(phoneNumber, 0, 9);

        TextField phoneNumberTextField = new TextField(immigrant.getPhoneNumber());
        editFormPane.add(phoneNumberTextField, 1, 9);

        Label email = new Label("Email:");
        editFormPane.add(email, 0, 10);

        TextField emailTextField = new TextField(immigrant.getEmail());
        editFormPane.add(emailTextField, 1, 10);


        Label dependent = new Label("Dependent: ");
        TextField dependent1 = new TextField(immigrant.getDependent());
        editFormPane.add(dependent1, 1, 9);

        ComboBox<String> dependentComboBox = new ComboBox<>();
        dependentComboBox.getItems().addAll("Fiance", "Children", "Fiancee");
        editFormPane.add(dependentComboBox, 1, 11);

        Label visaIDLabel = new Label("Visa ID:");
        editFormPane.add(visaIDLabel, 0, 12);

        TextField visaIDTextField = new TextField();
        editFormPane.add(visaIDTextField, 1, 12);


        // Assuming you have a button to save changes

        Button btn = new Button("Save");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        editFormPane.add(hbBtn, 1, 13);

        final Text actiontarget = new Text();
        editFormPane.add(actiontarget, 0, 14);
        editFormPane.setColumnSpan(actiontarget, 2);
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

        Scene scene = new Scene(editFormPane, 400, 550);
        primaryStage.setScene(scene);
    }
}

