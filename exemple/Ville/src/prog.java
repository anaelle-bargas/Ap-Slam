import java.util.*;
import java.io.*;

public class prog {
    public static PrintStream o = new PrintStream(System.out);
    public static Scanner i = new Scanner(System.in);
    public static void main(String[] args){
        Ville ville1= new Ville("Caen", "France", 106230);
        Ville ville2= new Ville("Dieppe", "France", 28813);
        

        // o.println(ville1.getNomVille());
        // ville1.setNomPays("Angleterre");
        // o.println(ville1.getNomPays());
        // o.println(ville1.getNbreHabitants());
        // o.println(ville1.getCategorie());
        // o.println(ville1.comparer(ville2));
        o.println(ville1.description(ville2));
        o.println(Ville.getNbreVilles());



    }
}


