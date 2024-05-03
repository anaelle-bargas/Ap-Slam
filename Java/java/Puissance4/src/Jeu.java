
import java.util.*;
import java.io.*;

public class Jeu {
    public static PrintStream o = new PrintStream(System.out);
    public static Scanner i = new Scanner(System.in);
    
    // private Humain joueurHumain;
    // private Machine joueurMachine;

    private Adversaire adversaire;
    private Adversaire joueur;
    private String vainqueur;
    private Grille grille;

    

    public Jeu(){

        // Demander les paramètres du jeu

        o.println("Quel est votre prénom ?");
        String answer1 = i.nextLine();
        this.joueur = new Adversaire("H", answer1, "*");
        String answer2;
        do{
            o.println("Souhaitez vous jouer avec un autre humain, ou avec la machine ? H pour humain, M pour machine");
            answer2 = i.nextLine().toUpperCase();
        }
        while(!answer2.equals("H") && !answer2.equals("M"));
        

        o.println("Quel est son prénom ?");
        String answer3 = i.nextLine();

        if(answer2 == "H"){

            this.adversaire = new Adversaire("H", answer3, "#");
            // this.joueurHumain = new Humain(answer3);
        }
        else{
            this.adversaire = new Adversaire("M", answer3, "#");
            // this.joueurMachine = new Machine(answer3);
        }

        o.println("Bon Courage et que le meilleur gagne !");


        this.vainqueur = "";
        this.grille = new Grille();

        // Commencer la partie
        gestionJeu();
    
    }

    public void gestionJeu(){
        int colonneChoisie;
        int i=0;
        Adversaire j;
        do{
            if(i%2==0){
                j = this.getJoueur();
            }
            else{
                j = this.getAdversaire();
            }
            colonneChoisie = partie(j);
            i++;
        }while(!estGagne(colonneChoisie, j));
    }

    public boolean estGagne(int colonne, Adversaire j){
        String [][] grille = this.getGrille().getGrille();
        int ligne = 0;
        while(grille[ligne][colonne]!="0"){
            ligne++;
        }
        this.getGrille().updateGrille(j.getPion(), ligne, colonne);
        
        for(int i=0;i<5;i++){
            for(int k=0;k<7;k++){
                if(grille[i][k]==j.getPion()){

                    // vérifier qu'il n'y a pas 4 pions consécutifs

                    //en ligne
                    if(i <=2){
                        if(grille[i][k]==j.getPion() && grille[i+1][k]==j.getPion() && grille[i+2][k]==j.getPion() && grille[i+3][k]==j.getPion()){
                            return true;
                        }
                    }
                    //TODO : en colonne 
                    if(i <=2){
                        if(grille[i][k]==j.getPion() && grille[i+1][k]==j.getPion() && grille[i+2][k]==j.getPion() && grille[i+3][k]==j.getPion()){
                            return true;
                        }
                    }
                }
            }
        }
        return true;
    }



    public int partie(Adversaire j){
        o.println("\n---------------"+j.getPrenom()+"---------------");
        o.println(this.getGrille());
        int colonne;
        do{
            o.println("Dans quelle colonne souhaitez-vous placer votre pion ? Inscrivez un nombre entre 1 et 7 inclus");
            colonne = i.nextInt();
        }while(colonne <1 || colonne >7);
        return colonne;

    }

    public Adversaire getJoueur(){
        return this.joueur;
    }

    public Adversaire getAdversaire(){
        return this.adversaire;
    }

    public Grille getGrille(){
        return this.grille;
    }
    // public Humain getJoueurHumain(){
    //     return this.joueurHumain;
    // }

    // public Machine getJoueurMachine(){
    //     return this.joueurMachine;
    // }



}
