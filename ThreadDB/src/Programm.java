public class Programm {
    public static void main(String[] args) {

        Datenbank db = new Datenbank();
        db.datenbankSchreiben();
    //    Thread t1 = new Thread(db);
     //   t1.start();

        db.getAnzahlZeilen();
        
    }
}
