import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class reessaie {
    public static PrintStream output = new PrintStream(System.out);
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        // age();
        // output.println(fahrenheit(25));
        // int[][] tab= {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}};
        // output.println(carreMagique(tab));
        output.println(estBissextile(2024));
    }

    public static boolean estBissextile (int annee){
        output.println(annee%400);
        return annee%400==0 && annee%4==0 && annee%100!=0 && annee%4000!=0;
    }

    public static boolean carreMagique(int[][] tab){
        int somme_ligne=0;
        int somme_diagonale_droite=0;
        int somme_diagonale_gauche=0;

        for(int i=0; i<tab[0].length;i++){
            somme_ligne+=tab[0][i];
        }

        for(int i=0; i<tab.length;i++){
            int somme_ligne_actuelle=0;
            int somme_colonne_actuelle=0;
            for(int j=0; j<tab[i].length;j++){
                somme_ligne_actuelle+=tab[i][j];
                somme_colonne_actuelle+=tab[j][i];
                if (i==j){
                    somme_diagonale_gauche+=tab[i][j];
                    somme_diagonale_droite+=tab[i][tab[i].length-j-1];
                }
            }
            if(somme_ligne_actuelle!=somme_ligne || somme_colonne_actuelle!=somme_ligne){
                return false;
            }
        }
        if(somme_diagonale_droite!=somme_ligne || somme_diagonale_gauche!=somme_ligne){
            return false;
        }
        return true;

    }

    public static float fahrenheit(float degres){
        return 9*degres/5+32;
    }

    public static void age(){
        output.println("Entre ton prénom :");
        String prenom = input.nextLine();

        output.println("Entre ton nom :");
        String nom = input.nextLine();
        int annee_a_connaitre;
        int annee_naissance;
        do{
            output.println("Entre ton anne de naissance :");
            annee_naissance = input.nextInt();
        }while(annee_naissance<0);

        do{
            output.println("Entre l'année où tu veux savoir ton âge :");
            annee_a_connaitre = input.nextInt();
        }while(annee_a_connaitre<0);

       
        
        output.println(annee_a_connaitre-annee_naissance);
    }
}