import java.io.PrintStream;
import java.util.Scanner;

public class Humain {
    public static PrintStream o = new PrintStream(System.out);
    public static Scanner i = new Scanner(System.in);
    
    private String prenom;

    public Humain(){

    }

    public Humain(String prenom){
        this.prenom = prenom;
    }

    public String getPrenom(){
        return this.prenom;
    }
}
