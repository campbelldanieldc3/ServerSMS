package ServerSMS;

import ServerSMS.Model.Server;

import java.io.IOException;

public class MainApplication {


    public static void main(String[] args){

        try{
            new Server();
        }
        catch (IOException io){

            io.printStackTrace();

        }

    }
}
