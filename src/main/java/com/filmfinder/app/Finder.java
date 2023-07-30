package src.main.java.com.filmfinder.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Finder {
    // i will clean this class up once i get a couple features
    // can i put the try and catch in the constructor? hopefully...
    // this is the class where the application performance is most dependent
    // improve queries to improve application speed

    public Finder() {
    }

    public List<String> getRandomTitles(int num) {
        // shows and movies

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DatabaseConnection.getConnection();
                    Statement statement = connection.createStatement()) {

                String query = "SELECT primary_title FROM title_basics ORDER BY RAND() LIMIT " + num;

                ResultSet resultSet = statement.executeQuery(query);

                List<String> randomTitles = new ArrayList<>();

                while (resultSet.next()) {
                    String title = resultSet.getString("primary_title");
                    randomTitles.add(title);
                }

                return randomTitles;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load MySQL JDBC driver.");
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getRandomMovies(int num) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DatabaseConnection.getConnection();
                    Statement statement = connection.createStatement()) {

                String query = "SELECT primary_title FROM title_basics WHERE title_type = 'movie' ORDER BY RAND() LIMIT "
                        + num;

                ResultSet resultSet = statement.executeQuery(query);

                List<String> randomTitles = new ArrayList<>();

                while (resultSet.next()) {
                    String title = resultSet.getString("primary_title");
                    randomTitles.add(title);
                }

                return randomTitles;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load MySQL JDBC driver.");
            e.printStackTrace();
        }
        return null;

    }
}
