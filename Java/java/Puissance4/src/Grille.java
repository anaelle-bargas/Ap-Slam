import java.util.*;
import java.io.*;
public class Grille {
    public static PrintStream o = new PrintStream(System.out);
    public static Scanner i = new Scanner(System.in);
    String[][] grille;
    public Grille(){
        // String[] carres = {"\033[0;37m\u2b1b", "\033[0;31m\u2b1b", "\033[0;33m\u2b1b"};
        String[][] grille = {{"0", "0", "0", "0", "0", "0", "0"},{"0", "0", "0", "0", "0", "0", "0"}, {"0", "0", "0", "0", "0", "0", "0"}, {"0", "0", "0", "0", "0", "0", "0"}, {"0", "0", "0", "0", "0", "0", "0"},{"0", "0", "0", "0", "0", "0", "0"}};

        this.grille = grille;
    }
    public String toString(){
        String chaine = "\n";
        for(int i =0;i<grille.length;i++){
            for(int j=0;j<grille[i].length;j++){
                chaine+=this.grille[i][j]+" ";
            }
            chaine+="\n";
        }
        return chaine;
    }
    public String[][] updateGrille(String value, int ligne, int colonne){
        this.getGrille()[ligne][colonne] = value;
        return this.getGrille();
    }
    public String[][] getGrille(){
        return this.grille;
    }
}
