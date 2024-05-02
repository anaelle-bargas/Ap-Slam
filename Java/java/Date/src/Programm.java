import java.util.*;
import java.io.*;
public class Programm {
    public static PrintStream o = new PrintStream(System.out);
    public static Scanner i = new Scanner(System.in);
    
    public static void main(String [] args) throws Exception{
        Date date1 = new Date();  
        date1.setAnnee(2023);
        date1.setMois(5);        
        date1.setJour(31);        
        Date date2 = new Date(30, 5, 2022);
        date1.afficher();
        date2.afficher();
        o.println(date1.difference(date2));
    }
 
}
