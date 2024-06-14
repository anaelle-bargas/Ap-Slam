import java.io.PrintStream;
import java.util.Random;
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
    public String toString(){
        return this.prenom;
    }

    public int choisirColonne(Jeu jeu){
        int colonne;
        if(this.getType()=="M"){

            Random rn = new Random();
            do{
                colonne = rn.nextInt(7) + 1;
            }
            while(jeu.getLigne(colonne-1)<0);
            System.out.println(colonne);
            
        }
        else{
            do{
                o.println("Dans quelle colonne souhaitez-vous placer votre pion ? Inscrivez un nombre entre 1 et 7 inclus");
                colonne = i.nextInt();
                }while(colonne <1 || colonne >7);
    
            while(jeu.getLigne(colonne-1)<0){
                do{
                    o.println("La colonne est déjà remplie, choisissez un autre chiffre entre 1 et 7");
                    colonne = i.nextInt();
                }while(colonne <1 || colonne >7);
            }
           
        }
        return colonne;
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
