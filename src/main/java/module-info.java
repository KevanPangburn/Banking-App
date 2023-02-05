module bank.bankingapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.j;


    opens bank.bankingapp to javafx.fxml;
    exports bank.bankingapp;
}