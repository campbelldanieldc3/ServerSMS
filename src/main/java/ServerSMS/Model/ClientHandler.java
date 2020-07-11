package ServerSMS.Model;


import ServerSMS.Service.Authenticator;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;

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
    private ObjectMapper mapper;

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
        mapper = new ObjectMapper();

    }
    //handle Client
    public void run(){
        boolean connected = true;
        String input;
        while(connected){
            try {

                int opCode = dataReader.readByte();
                input = dataReader.readUTF();
                System.out.println("[Client " + channel + "]: " + input);

                switch(opCode){

                    case -1:
                        connected = false;
                        break;
                    case 0:
                        AuthenticationRequest request = mapper.readValue(input, AuthenticationRequest.class);
                        if(Authenticator.authenticate(request)) {
                            dataWriter.writeShort(200); //signal success
                            dataWriter.flush();
                        }
                        else{
                            dataWriter.writeShort(400); //signal failure
                            dataWriter.flush();
                        }
                        break;
                    case 1:
                        //recovery via email
                        break;
                    case 2:
                        //process & Transport msg
                        break;
                    default:
                        //notify log w/ unknown / issues
                        break;

                }

            }
            catch (Exception e){

                try{
                    System.err.println("Client Connection " + channel + " has been disconnected.");
                    this.clientSocket.close();
                    this.dataReader.close();
                    //this.writeClient.close();
                    break;
                }
                catch(IOException f){
                    f.printStackTrace();
                }
                e.printStackTrace();
            }



        }
        try {

            System.err.println("Client Connection " + this.channel + " has been disconnected.");
            this.clientSocket.close();
            this.dataReader.close();
            //writeClient.close();
        }
        catch (IOException io){
            io.printStackTrace();
        }




    }

    }

