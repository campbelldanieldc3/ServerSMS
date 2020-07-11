package ServerSMS.Service;

import ServerSMS.Model.AuthenticationRequest;
import ServerSMS.Model.User;

import java.util.ArrayList;

public class Authenticator {

    private static ArrayList<User> connectedUsers = new ArrayList<User>();

    public static boolean authenticate(AuthenticationRequest request){


        //run DB check to provided creds
        //if(db.contains(request.Username) && request.password == db.get(passwordOfUser))
        addUser(request);
        return true;
    }
    //might be redundant to have Users & Requests w/ sme exact structure
    private static void addUser(AuthenticationRequest request){

        //TODO Pull Details from DB
    }

    public static boolean isConnected(String user){

        for(User u : connectedUsers){

            if(u.getuName().equals(user))
                return true;

        }

        return false;
    }
}
