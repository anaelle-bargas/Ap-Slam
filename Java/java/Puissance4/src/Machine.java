import java.io.PrintStream;
import java.util.Scanner;

public class Machine {

    public static PrintStream o = new PrintStream(System.out);
    public static Scanner i = new Scanner(System.in);
    
    private String prenom;
    public Machine(String prenom){
        this.prenom = prenom;
    }
}
