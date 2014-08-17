import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class tsdns implements Runnable {

    private Socket server;
    private String line, input;

    public MySQLAccess databaseCon;

    tsdns(Socket server) {
        this.server = server;
    }

    public void run() {
        input = "";

        try {
            // Get input from the client
            DataInputStream in = new DataInputStream(server.getInputStream());
            PrintStream out = new PrintStream(server.getOutputStream());

            /*
            while ((line = in.readLine()) != null && !line.equals(".")) {
                input = input + line;
                out.println("I got:" + line);
            }
            */

            line = in.readLine();
            input = input + line;

            String _ip = databaseCon.getIP(input);

            if(_ip.equalsIgnoreCase(""))
                _ip = "404";

            // Ausgabe an Client
            out.println(_ip);

            System.out.println("### Search ###\n#\n# Domain: " + input + "\n# IP: " + _ip + "\n### END Search ###");

            server.close();
        } catch (IOException ioe) {
            System.out.println("IOException on socket listen: " + ioe);
            ioe.printStackTrace();
        }
    }

}
