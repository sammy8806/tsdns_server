import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class init {

    private static int port = 41144, maxConnections = 0;

    public static void main(String[] args) throws Exception {
        MySQLAccess dao = new MySQLAccess();

        dao.initDB();
        //System.out.println(dao.getIP("2.localhost"));

        int i = 0;

        try {
            ServerSocket listener = new ServerSocket(port);
            Socket server;

            while ((i++ < maxConnections) || (maxConnections == 0)) {
                tsdns connection;

                server = listener.accept();
                tsdns conn_c = new tsdns(server);
                conn_c.databaseCon = dao;

                Thread t = new Thread(conn_c);
                t.start();
            }
        } catch (IOException ioe) {
            System.out.println("IOException on socket listen: " + ioe);
            ioe.printStackTrace();
        }
    }

}
