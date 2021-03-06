package atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class user extends dönüsüm {

    static Connection cont;
    static Statement stmt;

    /**/    user() throws Exception {
        baglantiAc();
    }

    /**/ public static void baglantiAc() throws Exception {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        cont = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/contact;create=true",
                "htdata", "yjç865.i");
        stmt = cont.createStatement();
    }


    /**/ public static void again() throws Exception {
        cont.close();
        baglantiAc();
    }

    /**/ public boolean logcheck(String user, String pass) throws Exception {
        String query = "SELECT  usern, password FROM PASS";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            if (user.equals(rs.getString("usern"))) {
                if (pass.equals(rs.getString("password"))) {
                    return true;
                }
            }

        }
        return false;
    }

    /**/ public boolean changepass(String newpass, String usern) throws Exception {
        String query = "UPDATE PASS SET password = '" + newpass + "' WHERE usern = '" + usern + "'";
        int num = stmt.executeUpdate(query);
        if (num == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**/ public boolean depomoney(String usern, double mik) throws Exception {
        String oldman = "SELECT bakiye,usern FROM HLIMIT ";
        ResultSet rs = stmt.executeQuery(oldman);
        while (rs.next()) {
            if (usern.equals(rs.getString("usern"))) {
                mik += this.setno(rs.getString("bakiye"));
                String query = "UPDATE HLIMIT SET bakiye=" + mik + " WHERE usern='" + usern + "'";
                int num = stmt.executeUpdate(query);
                if (num == 1) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    /**/ public boolean cekmoney(String usern, double mik) throws Exception {
        String oldman = "SELECT bakiye,usern FROM HLIMIT WHERE usern='" + usern + "'";
        ResultSet rs = stmt.executeQuery(oldman);
        while (rs.next()) {
            if (usern.equals(rs.getString("usern"))) {
                double mikk = this.setno(rs.getString("bakiye"));
                if (mikk > mik) {
                    mikk -= mik;
                    String query = "UPDATE HLIMIT SET bakiye=" + mikk + " WHERE usern='" + usern + "'";
                    int num = stmt.executeUpdate(query);
                    if (num == 1) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    /**/

    public String namecheck(String user, String nname) throws Exception {
        
        String query = "SELECT  usern,name,nickn FROM NAMES";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            if (user.equals(rs.getString("name"))) {
                if (nname.equals(rs.getString("nickn"))) {
                    System.out.println(rs.getString("nickn"));
                     return rs.getString("usern");
                }
            }
        }
        return "";
    }

    public boolean sendmoney(String usern1,String usern2,String miktar)throws Exception{
        
        double tutar=setno(miktar);
        boolean door1=cekmoney(usern1,tutar);
        again();
        boolean door2=depomoney(usern2,tutar);
        if(door1 && door2){
            return true;
        }
        return false;
    }
    
    
}
