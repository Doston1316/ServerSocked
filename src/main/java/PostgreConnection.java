import java.sql.Connection;
import java.sql.DriverManager;

public class PostgreConnection {
    public static Connection con = null;
    private PostgreConnection() {
    }

    public static Connection getInstance(String connectionUrl) throws Exception {
        if (con == null || con.isClosed()) {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, main.userName, main.password);
        }
        return con;
    }

}
