package ServerSMS.Model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final int PORT = 27800;

    private ServerSocket mainSocket;


    public Server() throws IOException{

        mainSocket = new ServerSocket(PORT);

        System.err.println("Server Started on port: " + PORT);
        //loop to sit and wait for client connection
        //TODO: Update Loop Condition to allow Manual-Override to Server: TO be updated when Server /
        // Admin GUI is created
        while(true){

            Socket clientSocket = mainSocket.accept();

            new ClientHandler(clientSocket).start();
        }
    }

}
