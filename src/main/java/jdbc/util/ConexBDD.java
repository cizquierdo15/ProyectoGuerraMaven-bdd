package jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexBDD {
	private static String url = "jdbc:mysql://localhost:3306/curso_java?serverTimezone=Europe/Madrid";
    private static String username = "root";
    private static String password = "sk8123456";
    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}
