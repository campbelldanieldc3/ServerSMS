package ServerSMS.Model;

public class User{

    private String uName, uPass, uEmail;

    public User(String uName, String uPass, String uEmail){

        this.uName = uName;
        this.uPass = uPass;
        this.uEmail = uEmail;

    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPass() {
        return uPass;
    }

    public void setuPass(String uPass) {
        this.uPass = uPass;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }
}
