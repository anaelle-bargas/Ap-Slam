import java.io.PrintStream;
import java.util.Scanner;

public class Machine extends Adversaire{

    public static PrintStream o = new PrintStream(System.out);
    public static Scanner i = new Scanner(System.in);
    
    private String prenom;
    public Machine(String prenom){
        super();
        this.prenom = prenom;
    }
}
