package nytOdevPac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
    private Connection getC() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/nyatOdev",
                            "postgres", "fatih");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return c;
    }

    public boolean kullaniciDogrula(String ad,String sifre){
        boolean dogru = false;
        Connection c  = null;
        Statement stmt = null;
        try {
            c = getC();
            stmt=c.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM KULLANICI WHERE KULLANICIAD='" +ad+ "' AND SIFRE='" +sifre+"'");
            while (rs.next())  {
                int id =rs.getInt("id");
                String _ad=rs.getString("kullaniciad");
                String _sifre=rs.getString("sifre");

                if(!(_ad == ad && _sifre == sifre)){
                    dogru = true;
                    System.out.println("Giris Dogru");
                    break;
                }else{
                    dogru = false;
                    System.out.println("Giris Yanlis");
                }
            }
            rs.close();
            stmt.close();
            c.close();

        } catch (Exception e){
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return dogru;
    }

}
