import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class Datenbank {

    public void datenbankSchreiben() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Connection con = null;


            }
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/thread_db", "root", "");
            con.setAutoCommit(false);

            Statement stat = con.createStatement();

            //Random Passwort erzeugen mit 8 Zeichen 
            for(int i = 1; i < 100; i++) {
                String passwort = "";
                for(int j = 0; j < 8; j++) {
                    char c = (char)(new Random().nextInt(123-97) + 97);
                    passwort += c;
                    }
                System.out.println(passwort);
                //in DB schreiben
                stat.execute("CREATE TABLE IF NOT EXISTS daten(ID int, passwort varchar(255));");
                stat.execute("Insert INTO daten (passwort) VALUES('" + passwort + "');");
            }
            con.commit();
            con.close();
            
        } catch (Exception e) {
                try {
                    con.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            e.printStackTrace();
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

public void getAnzahlZeilen() {
    try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/thread_db", "root", "");
        Statement stat = con.createStatement();

        ResultSet rs = stat.executeQuery("SELECT COUNT(passwort) FROM daten;");
        rs.next();
        System.out.println("rs.getInt()");
        

        con.close();
    }
    catch(SQLException e) {
        e.printStackTrace();
    }
}

//@Override


}
    

