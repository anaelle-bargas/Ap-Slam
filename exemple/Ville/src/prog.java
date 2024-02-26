import java.util.*;
import java.io.*;

public class prog {
    public static PrintStream o = new PrintStream(System.out);
    public static Scanner i = new Scanner(System.in);
    public static void main(String[] args){
        Ville ville1= new Ville("Caen", "France", 106230);

        o.println(ville1.nomVille);
        o.println(ville1.nomPays);
        o.println(ville1.nbreHabitants);



    }
}


