# Simple Banking App

A simple banking app made using Java, JavaFX, and MySQL. This app allows users to manage their bank account by checking balance, depositing and withdrawing money. It also implements user login and authentication by retrieving user credentials from the MySQL database.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java 8 or above
- MySQL Workbench
- JavaFX Library

### Installation

1. Clone or download the repository to your local machine
2. Import the SQL script (banking_app.sql) to your MySQL Workbench to create the database
3. Update the database configuration in the DatabaseConnection.java file to match your MySQL credentials.
4. Compile and run the project using your preferred Java development environment.

## Usage

Upon launch, the app will prompt the user to enter their login credentials (username and password) or direct the user to register a new account. The app will retrieve the user's account balance and transaction history from the MySQL database after successful authentication.

The app has three main functions:
- Withdraw money from the account
- Deposit money into the account
- Check account balance

The account balance is stored in the MySQL database and is updated after every transaction.

## Conclusion

This Simple Banking App is a basic demonstration of how to interact with a MySQL database using Java and JavaFX and implements user authentication. It can be used as a starting point for more complex banking applications.
