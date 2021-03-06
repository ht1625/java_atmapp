package atm;

import static atm.signclas.user;
import static atm.user.stmt;
import java.util.Random;

public class atm {

    public static void main(String[] args) throws Exception {

        loginn log = new loginn();
        log.setVisible(true);

    }
}

abstract class dönüsüm{
 
 public  double setno(String no) {
        String temp = "";
        for (int i = 0; i < no.length(); i++) {
            char at = no.charAt(i);
            int sayı = (at);
            if ((sayı >= 48 && sayı <= 57) || sayı == 46) {
                temp += at;
            }
        }
        if (no.equals("")) {
            return 0;
        } else {
            return Double.valueOf(temp);
        }
    }
}

