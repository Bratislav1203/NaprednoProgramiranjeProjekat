package fon.ai.maventransportappserver.main;
import java.sql.SQLException;
import javax.swing.JFrame;
import fon.ai.maventransportappserver.server.forms.FServer;

/**
 *
 * @author stackOverflow
 */

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        JFrame jf = new FServer();
        jf.setVisible(true);
        System.out.println("Just test Server");
    }
    
}
