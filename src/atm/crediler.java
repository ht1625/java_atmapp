package atm;

import static atm.user.again;
import static atm.user.cont;
import static atm.user.stmt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class crediler extends dönüsüm {

    static Connection cont;
    static Statement stmt;

    crediler() throws Exception {
        baglantiAc();
    }

    public static void baglantiAc() throws Exception {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        cont = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/contact;create=true",
                "htdata", "yjç865.i");
        stmt = cont.createStatement();
    }

    public static void again() throws Exception {
        cont.close();
        baglantiAc();
    }

    public boolean getcreditonay(String usern) throws Exception {
        String door = "SELECT creditonay,usern FROM CONAY ";
        ResultSet rs = stmt.executeQuery(door);
        while (rs.next()) {
            if (usern.equals(rs.getString("usern"))) {
                if (rs.getString("creditonay").equals("true")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean getcredistek(String usern) throws Exception {
        String door = "SELECT usern,credistek FROM NAMES";
        ResultSet rs = stmt.executeQuery(door);
        while (rs.next()) {
            if (usern.equals(rs.getString("usern"))) {
                if (rs.getString("credistek").equals("true")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean docredırequest(String usern) throws Exception {

        String query2 = "UPDATE NAMES SET credistek='true' WHERE usern='" + usern + "'";
        int num = stmt.executeUpdate(query2);
        if (num == 1) {
            return true;
        }
        return false;
    }

    public String credilimit(String user, String password) throws Exception {
        String query = "SELECT  usern,credilimit FROM CLIMIT";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            if (user.equals(rs.getString("usern"))) {
                return rs.getString("credilimit");
            }
        }
        return "";
    }


    public boolean dontcredırequest(String user) throws Exception {
        again();
        String query2 = "UPDATE NAMES SET credistek='false' WHERE usern='" + user + "'";
        int num = stmt.executeUpdate(query2);
        if (num == 1) {
            return true;
        }
        return false;
    }

    public boolean doclimit(double miktar, String usern) throws Exception {

        again();
        String query2 = "UPDATE CLIMIT SET credilimit=" + miktar + " WHERE usern='" + usern + "'";
        int num = stmt.executeUpdate(query2);

        if (num == 1) {
            return true;
        }
        return false;

    }

    public boolean docredilimit(String[] names, String mik) throws Exception {

        String query = "SELECT  usern,name,nickn FROM NAMES";
        ResultSet rs = stmt.executeQuery(query);
        double miktar = setno(mik);
        while (rs.next()) {
            if (names[0].equals(rs.getString("name"))) {
                if (names[1].equals(rs.getString("nickn"))) {
                    boolean dor = dontcredırequest(rs.getString("usern"));
                    boolean num = doclimit(miktar, rs.getString("usern"));
                    if (num && dor) {
                        return true;
                    }
                }
            }
            
        }
        return false;
    }

    
    
    
}
