package com1;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application {

    private ApplicationDriver applicationDriver; // ApplicationDriver instance
    private Stage stage; // Reference to the stage

    public Login(ApplicationDriver applicationDriver) {
        this.applicationDriver = applicationDriver;
    }

    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage; // Store the stage reference
        primaryStage.setTitle("Immigration Login");
        setupUI(primaryStage);
        primaryStage.show();
    }

    // Method to close the stage
    public void stop() {
        if (stage != null) {
            stage.close();
        }
    }

    // Method to setup UI elements
    private void setupUI(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 0, 6);
        grid.setColumnSpan(actiontarget, 2);
        actiontarget.setFill(Color.FIREBRICK);

        btn.setOnAction(e -> {
            // Check login credentials
            String username = userTextField.getText();
            String password = pwBox.getText();

            if (isValidLoginDataEntry(username, password)) {
                actiontarget.setText("Login successful!");
                applicationDriver.handleSuccessfulLoginDataEntry();
            }

            if (isValidLoginReview(username, password)) {
                actiontarget.setText("Login successful!");
                applicationDriver.handleSuccessfulLoginReview();
            }

            if (isValidLoginDataApprove(username, password)) {
                actiontarget.setText("Login successful!");
                applicationDriver.handleSuccessfulLoginApprove();
            }
                actiontarget.setText("Invalid username or password!");


        });

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
    }

    // Dummy method to simulate login validation
    private boolean isValidLoginDataEntry(String username, String password) {
        return "dataEntry".equals(username) && "123".equals(password);
    }

    private boolean isValidLoginReview(String username, String password) {
        return "review".equals(username) && "123".equals(password);
    }

    private boolean isValidLoginDataApprove(String username, String password) {
        return "approve".equals(username) && "123".equals(password);
    }

}
