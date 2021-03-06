
package atm;


public class signclas extends user{

    static userknowledge user;

    signclas(userknowledge usr) throws Exception {
        super();
        user=usr;
    }

    public void getname() throws Exception {
System.out.println("sdfmö" );
        String query = "INSERT INTO NAMES (usern,name,nickn,credistek) VALUES ('"
                + user.setuser() + "','" + user.setname() + "','" + user.setnname() + "','false')";
        stmt.executeUpdate(query);
        
    }
    
    public void getpass()throws Exception{
        System.out.println("sdfmö" );
        String query = "INSERT INTO PASS VALUES ('"
                + user.setuser() + "','" + user.setpass() + "')";
        stmt.executeUpdate(query);
    }
    
    public void gethlimit()throws Exception{
        System.out.println("sdfmö" );
        String query = "INSERT INTO HLIMIT  VALUES ('"
                + user.setuser()+ "'," + user.setbak() + ")";
        stmt.executeUpdate(query);
    }
    
    public void getclimit()throws Exception{
        System.out.println("sdfmö" );
        String query = "INSERT INTO CLIMIT (usern) VALUES ('"
                + user.setuser()+ "')";
        stmt.executeUpdate(query);
    }
    
    public void getconay()throws Exception{
        System.out.println("sdfmö" );
        String query = "INSERT INTO CONAY VALUES ('"
                + user.setuser()+ "','" + user.setconay() + "')";
        stmt.executeUpdate(query);
    }

    
    public void getfat()throws Exception{
        System.out.println("sdfmö" );
        String query = "INSERT INTO BILLS  VALUES ('"
                + user.setuser()+"',"+user.setsu()+","+user.setelec()+ "," + user.settel() + ")";
        stmt.executeUpdate(query);
    }
}
