package atm;

import java.util.Random;

public class userknowledge {

    private String firstname, nickname, passwordd, username;
    private double balnce, fatsu, fattel, fatelec;
    public String creditonay;

    public void getname(String name) {
        this.firstname = name;
    }

    public void getnname(String nname) {
        this.nickname = nname;
    }

    public void getpass(String pass) {
        this.passwordd = pass;
    }

    public void getuser(String user) {
        this.username = user;
    }

    public void getbalance(double bl) {
        this.balnce = bl;
    }

    public void getcredilimit(String sl) {
        this.creditonay = sl;
    }



    userknowledge() {
    }

    ;
    userknowledge(String nm, String nnm, String pas, double bl, String usern, String onay) {
        this.firstname = nm;
        this.nickname = nnm;
        this.passwordd = pas;
        this.balnce = bl;
        this.username = usern;
        this.creditonay = onay;
        dorandombil();
        System.out.println(fatsu + " " + fattel + " " + fatelec);
    }

    public String setname() {
        return firstname;
    }

    public String setnname() {
        return nickname;
    }

    public String setpass() {
        return passwordd;
    }

    public String setuser() {
        return username;
    }

    public double setbak() {
        return balnce;
    }

    public double setsu() {
        return fatsu;
    }

    public double settel() {
        return fattel;
    }

    public double setelec() {
        return fatelec;
    }

    public String setconay() {
        return creditonay;
    }


    public void dorandombil() {

        Random rnd = new Random();
        fatsu = rnd.nextInt(100);
        fatelec = rnd.nextInt(250);
        fattel = rnd.nextInt(100);
    }
}
