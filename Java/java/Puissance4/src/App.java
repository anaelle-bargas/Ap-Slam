import java.util.*;
import java.io.*;

public class App {
    public static PrintStream o = new PrintStream(System.out);
    public static Scanner i = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        System.out.println("PUISSANCE 4");

        // classe qui gère le visuel
        // classe qui est un joueur humain
        // classe qui ets une joueur machine
        // classe qui gère le Jeu
        // classe qui gère le paramêtres du jeu
        new Jeu();
        // o.println(new Grille());
    }
}
