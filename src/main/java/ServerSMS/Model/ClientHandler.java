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

        String input;
        while(true){
            try {
                input = dataReader.readUTF();
                System.out.println("[Client " + channel + "]: " + input);
                String[] totalInput = input.split("-");

                if (totalInput[0].equals("QUIT")) {
                    break;
                } else {

                    if(totalInput[0].equals("LOGIN")){
                        //DBA LOOK UP
                        //ADD USER
                    }
                    //AuthenticationService.findUser(totalInput[1], totalInput[2]);
                    else if(totalInput[0].equals("RESET")){
                        //client sends reset request for account

                    }
                    else if (totalInput[0].equals("")){

                    }
                    else{

                        System.err.println("Command Not Recognized.");

                    }




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

