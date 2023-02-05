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


public class LoginSceneController implements Initializable {

    @FXML
    private Button cancelButton;
    @FXML
    private Label loginInvalidMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterPasswordField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void loginButtonOnAction(ActionEvent event) {
        if (usernameTextField.getText().isBlank() || enterPasswordField.getText().isBlank()) {
            loginInvalidMessageLabel.setText("Invalid login. Please try again.");
        } else {
            validateLogin();
        }

    }

    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDb = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM user_account WHERE username = '" + usernameTextField.getText() + "' AND password ='" + enterPasswordField.getText() + "'";

        try {

            Statement statement = connectDb.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    accountScreen();
                } else {
                    loginInvalidMessageLabel.setText("Invalid login. Please try again.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    public void createAccountForm() {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("RegistrationScene.fxml"));
            Stage registrationStage = new Stage();
            registrationStage.setScene(new Scene(root, 500, 400));
            registrationStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    public void accountScreen() {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("AccountScene.fxml"));
            Stage registrationStage = new Stage();
            registrationStage.setScene(new Scene(root, 500, 400));
            registrationStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

}