package bank.bankingapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;
import java.sql.Connection;
import java.sql.Statement;

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
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField usernameTextField;

    public void cancelButtonOnAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("loginScene.fxml"));
            Stage registrationStage = new Stage();
            registrationStage.setScene(new Scene(root, 500, 400));
            registrationStage.getIcons().add(new Image("file:src/main/resources/piggy.png"));
            registrationStage.setTitle("Banking App");
            registrationStage.show();

            Stage loginStage = (Stage) cancelButton.getScene().getWindow();
            loginStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerButtonOnAction(ActionEvent event) {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String text = change.getText();
            if (text.isBlank()) {
                return change;
            }
            return change;
        };

        TextFormatter<String> firstnameFormatter = new TextFormatter<>(filter);
        firstnameTextField.setTextFormatter(firstnameFormatter);

        TextFormatter<String> lastnameFormatter = new TextFormatter<>(filter);
        lastnameTextField.setTextFormatter(lastnameFormatter);

        TextFormatter<String> usernameFormatter = new TextFormatter<>(filter);
        usernameTextField.setTextFormatter(usernameFormatter);

        if (firstnameTextField.getText().isBlank() || lastnameTextField.getText().isBlank() ||
                usernameTextField.getText().isBlank()) {
            confirmPasswordLabel.setText("Please fill in all fields.");
        } else if (setPasswordField.getText().isBlank() || confirmPasswordField.getText().isBlank()) {
            confirmPasswordLabel.setText("Please enter password.");
        } else if (setPasswordField.getText().equals(confirmPasswordField.getText())) {
            registerUser();
        } else {
            confirmPasswordLabel.setText("Password does not match.");
        }
    }

    public void registerUser() {
        DatabaseConnection registerDB = new DatabaseConnection();
        Connection connectDB = registerDB.getConnection();

        String firstname = firstnameTextField.getText();
        String lastname = lastnameTextField.getText();
        String username = usernameTextField.getText();
        String password = setPasswordField.getText();
        double balance = 0;

        String insertFields = "INSERT INTO user_account(lastname, firstname, username, balance, password) VALUES ('";
        String insertValues = firstname + "','" + lastname + "','" + username + "','" + balance + "','" + password + "')";
        String insertToRegister = insertFields + insertValues;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
            accountScreen();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    public void accountScreen() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AccountScene.fxml"));
            Stage accountStage = new Stage();
            accountStage.setScene(new Scene(root, 500, 400));
            accountStage.show();

            Stage registrationStage = (Stage) cancelButton.getScene().getWindow();
            registrationStage.close();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

}
