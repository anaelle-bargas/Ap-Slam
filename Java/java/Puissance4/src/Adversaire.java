import java.io.PrintStream;
import java.util.Scanner;


public class Adversaire {
    public static PrintStream o = new PrintStream(System.out);
    public static Scanner i = new Scanner(System.in);

    private String prenom;
    private String type;
    private String pion;

    public Adversaire(){
        this.prenom = "";
        this.type = "H";
        this.pion = "*";
    }

    public Adversaire(String type, String prenom, String pion){
        this.prenom = prenom;
        this.type = type;
        this.pion = pion;

    }

    public String getPrenom(){
        return this.prenom;
    }
    public String getType(){
        return this.type;
    }
    public String getPion(){
        return this.pion;
    }


}
