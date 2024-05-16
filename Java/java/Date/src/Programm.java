import java.util.*;
import java.io.*;
public class Programm {
    public static PrintStream o = new PrintStream(System.out);
    public static Scanner i = new Scanner(System.in);
    
    public static void main(String [] args) throws Exception{
        // Date date1 = new Date();  
        // date1.setAnnee(2023);
        // date1.setMois(5);        
        // date1.setJour(1);        
        Date date1 = new Date(1, 5, 2026);
        Date date2 = new Date(3, 5, 2022);
        Date date3 = new Date(1, 4, 2022);
        // o.println(date1);
        // o.println(date2);
        // o.println(date1.difference(date2));
        Evenement e1 = new Evenement(2, 5, 2022, "bla");
        Evenement e2 = new Evenement(1, 5, 2022, "bla");
        // o.println(e1);
        // o.println(date2.compareTo(date1));
        // o.println(e2.compareTo(e1));
        // ArrayList<Date> lesDates = new ArrayList<Date>();
        // lesDates.add(date2);
        // lesDates.add(date1);
        // lesDates.add(e1);
        // lesDates.add(e2);

        // Collections.sort(lesDates);

        // for(Date uneDate : lesDates){
        //     o.println(uneDate);
        // }
        ArrayList<Date> lesDates = new ArrayList<Date>();
        lesDates.add(date1);
        lesDates.add(date2);
        lesDates.add(date3);
        lesDates.add(e1);
        lesDates.add(e2);
        Collections.sort(lesDates);
        for(Date d : lesDates){
            o.println(d);
        }
        o.println(e1.egale(e2));


    }
 
}
