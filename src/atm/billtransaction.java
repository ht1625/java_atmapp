package atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class billtransaction extends dönüsüm{

    static Connection cont;
    static Statement stmt;

    billtransaction() throws Exception {
        baglantiAc();
    }

    public static void again() throws Exception {
        cont.close();
        baglantiAc();
    }

    public static void baglantiAc() throws Exception {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        cont = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/contact;create=true",
                "htdata", "yjç865.i");

        stmt = cont.createStatement();
    }

    public String getbilvalue(String username, String bill) throws Exception {
        String query = "SELECT usern,subill,telbill,elecbill FROM BILLS";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            if (username.equals(rs.getString("usern"))) {
                return rs.getString(bill);
            }
        }
        return "";
    }

    public   boolean doupdate(String q)  throws Exception {
 
        int num = stmt.executeUpdate(q);
        if (num == 1) {
            return true;
        }
        return false;
    }

    public boolean hlimit(String username, String bill) throws Exception {
        String bill2 = getbilvalue(username, bill);
        double bakiye = 0, bil = setno(bill2);
        String query = "SELECT usern,bakiye FROM HLIMIT";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            if (username.equals(rs.getString("usern"))) {
                bakiye = setno(rs.getString("bakiye"));
                if (bakiye >= bil) {
                    query = "UPDATE BILLS SET " + bill + "=0 WHERE usern='" + username + "'";
                    doupdate(query);
                    again();
                    query = "UPDATE HLIMIT SET bakiye=" + (bakiye - bil) + " WHERE usern='" + username + "'";
                    doupdate(query);
                    return true;
                }
            }
        }
        return false;
    }
    
    
    public boolean climit(String username,String bill)throws Exception{
        String bill2 = getbilvalue(username, bill);
        double bakiye = 0, bil = setno(bill2);
        String query = "SELECT usern,credilimit FROM CLIMIT";
          ResultSet  rs = stmt.executeQuery(query);
            while (rs.next()) {
                if (username.equals(rs.getString("usern"))) {
                    bakiye = setno(rs.getString("credilimit"));
                    if (bakiye >= bil) {
                        query = "UPDATE BILLS SET " + bill + "=0 WHERE usern='" + username + "'";
                        doupdate(query);
                        again();
                        String query2 = "UPDATE CLIMIT SET credilimit=" + (bakiye - bil) + " WHERE usern='" + username + "'";
                        doupdate(query2);
                        return true;
                    } 
                }
            }
        return false;
    }

    public boolean paybill(String username, String optionpay, String bill) throws Exception {
      
       
        if (optionpay.equals("HLIMIT")) {
            return  hlimit(username,bill);
        } else {
            
            }
        
        return false;
    }

}
