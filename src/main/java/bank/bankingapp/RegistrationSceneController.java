package bank.bankingapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import java.net.URL;

public class RegistrationSceneController {

    @FXML
    private Button cancelButton;

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
}
