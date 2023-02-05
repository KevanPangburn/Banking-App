package bank.bankingapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;
    public Connection getConnection() {
        String databaseName = "bank_db";
        String databaseUser = "pangburnkevan";
        String databasePassword = "testdb";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
        }catch(Exception e) {
            e.printStackTrace();
            e.getStackTrace();
        }

        return databaseLink;
    }
}