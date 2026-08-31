package conexion;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionBD {

    private static final String PROPERTIES_FILE = "config/database.properties";

    public static Connection obtenerConnection() throws SQLException {
        Properties props = new Properties();
        try (FileInputStream input = new FileInputStream(PROPERTIES_FILE)) {
            props.load(input);
        } catch (IOException e) {
            throw new SQLException("No se pudo cargar la configuración de la base de datos.", e);
        }

        String url = props.getProperty("db.url");
        String username = props.getProperty("db.username");
        String password = props.getProperty("db.password");

        if (url == null || username == null || password == null) {
            throw new SQLException("Faltan propiedades de conexión en config/database.properties");
        }

        return DriverManager.getConnection(url, username, password);
    }
}
