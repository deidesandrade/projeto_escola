
package faculdade.projetoescola;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection connect() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");  // "org.postgresql.Driver" com "p" minúsculo
            Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/estacio",
                "postgres", "admin");
            return connection;
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC não encontrado", e);
        }
    }
}

