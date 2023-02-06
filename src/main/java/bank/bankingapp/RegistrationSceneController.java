package bank.bankingapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class RegistrationSceneController {

    @FXML
    private Button cancelButton;
    @FXML
    private PasswordField setPasswordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Label confirmPasswordLabel;
    @FXML
    private Button registrationButton;

    public void cancelButtonOnAction(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("loginScene.fxml"));
            Stage registrationStage = new Stage();
            registrationStage.setScene(new Scene(root, 500, 400));
            registrationStage.show();

            Stage loginStage = (Stage) cancelButton.getScene().getWindow();
            loginStage.close();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void registerButtonOnAction(ActionEvent event) {
        registerUser();
    }

    public void registerUser() {
        try {
            if (setPasswordField.getText().isBlank() || confirmPasswordField.getText().isBlank()) {
                confirmPasswordLabel.setText("Please enter password.");
            }
            else if (setPasswordField.getText().equals(confirmPasswordField.getText())) {
                confirmPasswordLabel.setText("Place holder");
            } else {
                confirmPasswordLabel.setText("Password does not match.");
            }
        } catch (Exception e) {
            System.err.println("An error occurred while registering the user: " + e);
            e.printStackTrace();
        }
    }
}
