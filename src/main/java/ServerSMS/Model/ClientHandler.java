package ServerSMS.Model;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler extends Thread {

    private static int id = 0;
    private int channel;
    private Socket clientSocket;
    private DataInputStream dataReader;
    private DataOutputStream dataWriter;

    public ClientHandler(Socket client){
        channel = ++id;
        this.clientSocket = client;

        try{
            dataReader = new DataInputStream(clientSocket.getInputStream());
        }
        catch (IOException io){
            io.printStackTrace();
        }
        //replace w/ logging system
        System.out.println("New Client Connection from " + clientSocket.getInetAddress());


    }
    //handle Client
    public void run(){

    }
}
