package src.main.java.com.filmfinder.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/film_finder_db";
        String username = "film_finder_user";
        String password = "herGuy42069%";

        return DriverManager.getConnection(url, username, password);
    }
}
