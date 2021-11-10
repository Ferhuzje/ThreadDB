import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class Datenbank {

    public void datenbankSchreiben() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/thread_db", "root", "");
            Statement stat = con.createStatement();

            for(int i = 1; i < 1000; i++) {
                String passwort = "";
                for(int j = 0; j < 8; j++) {
                    char c = (char)(new Random().nextInt(123-97) + 97);
                    passwort += c;
                    }
                System.out.println(passwort);
                //DB in DB schreiben
                stat.execute("CREATE TABLE IF NOT EXISTS daten(ID int, passwort varchar(255));");


            
                stat.execute("Insert INTO daten (passwort) VALUES('" + passwort + "');");
            }
            con.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
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
    

