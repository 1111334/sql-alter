package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {


        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database-test", "root", "Maicoldevelhope12.");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM `table-sql`");

            while (resultSet.next()) {
                String studentId = resultSet.getString("student_id");
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");
                String country = resultSet.getString("country");

                String resultRow = "Student ID: " + studentId + ", Last Name: " + lastName + ", First Name: " + firstName + " Country: " + country;
                System.out.println(resultRow);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}