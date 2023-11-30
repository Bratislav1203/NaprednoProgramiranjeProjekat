package fon.ai.maventransportappserver.threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stackOverflow
 */
public class ServerThread extends Thread{
    private final ServerSocket serverSocket;
    private final List<ClientHandlerThread> clients;

    public ServerThread() throws IOException {
        serverSocket=new ServerSocket(9000);
        clients=new ArrayList<>();
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public List<ClientHandlerThread> getClients() {
        return clients;
    }
    
    public void closeServerThread() throws IOException{
        serverSocket.close();
    }
    
    public void closeAllClientsThreads() throws IOException{
        for(ClientHandlerThread c : clients){
            c.getSocket().close();
        }
    }
    
    @Override
    public void run() {
        while(!serverSocket.isClosed()){
            System.out.println("Waiting for new clients...");
            try {
                Socket socket=serverSocket.accept();
                ClientHandlerThread client=new ClientHandlerThread(socket);
                System.out.println("Uspesno");
                client.start();
                clients.add(client);
                System.out.println("Client connected.");
            } catch (IOException ex) {
                System.out.println("Server is closed.");
            }
            
        }
        try {
            closeAllClientsThreads();
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void stopServerThread() throws Exception {
        serverSocket.close();
    }
    
}
