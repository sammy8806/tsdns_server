import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mysql {

    private String host = "127.0.0.1";
    private String port = "3306";
    private String user = "tsdns";
    private String pass = "tsdns";
    private String database = "tsdns";

    private boolean connected = false;

    private Connection conn;

    public mysql() {
        if(!this.connected) {
            String DbUrl = "jdbc:mysql://" + this.host + ":" + this.port + "/" +
                    this.database +
                    "?user=" + this.user +
                    "&pass=" + this.pass;

            // mysql.forName("com.mysql.jdbc.Driver");
            // this.conn = new DriverManager.getConnection(DbUrl);
        }
    }

    public static String getName(String _ip) {
        return "";
    }


}
