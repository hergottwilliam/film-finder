package src.main.java.com.filmfinder.app;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DatabaseConnection.getConnection();
                    Statement statement = connection.createStatement()) {

                String query = "SELECT primary_title FROM title_basics ORDER BY RAND() LIMIT 5";

                ResultSet resultSet = statement.executeQuery(query);

                List<String> randomTitles = new ArrayList<>();

                while (resultSet.next()) {
                    String title = resultSet.getString("primary_title");
                    randomTitles.add(title);
                }

                System.out.println("5 Random Movie titles:");
                for (String title : randomTitles) {
                    System.out.println(title);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load MySQL JDBC driver.");
            e.printStackTrace();

        }
    }
}