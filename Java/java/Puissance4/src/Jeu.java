
import java.util.*;
import java.io.*;

public class Jeu extends Grille{
    public static PrintStream o = new PrintStream(System.out);
    public static Scanner i = new Scanner(System.in);
    
    // private Humain joueurHumain;
    // private Machine joueurMachine;

    private Adversaire adversaire;
    private Adversaire joueur;
    private String vainqueur;
    private Grille grille;
    private int partie;

    

    public Jeu(){
        super();
        // PARAMETRES DE JEU

        // Prenom du joueur principal
        o.println("Quel est votre prénom ?");
        String answer1 = i.nextLine();
        this.joueur = new Adversaire("H", answer1, "*");
        String answer2;

        // Adversaire humain ou machine
        do{
            o.println("Souhaitez vous jouer avec un autre humain, ou avec la machine ? H pour humain, M pour machine");
            answer2 = i.nextLine().toUpperCase();
        }
        while(!answer2.equals("H") && !answer2.equals("M"));
        
        // Prenom de l'adversaire
        o.println("Quel est son prénom ?");
        String answer3 = i.nextLine();
        System.out.println(answer2);

        System.out.println(answer2=="H");
        if(answer2.equals("H")){
            System.out.println("huamn");
            this.adversaire = new Adversaire("H", answer3, "#");
        }
        else{
            System.out.println("machine");

            this.adversaire = new Adversaire("M", answer3, "#");
        }

        o.println("Bon Courage et que le meilleur gagne !");

        this.vainqueur = "";
        this.grille = new Grille();
        this.partie=0;
        // Commencer la partie
        gestionJeu();
        
    }
    
    public void gestionJeu(){
        int colonneChoisie;
        int i=0;
        Adversaire j;
        String [][] grille = this.getGrille();
        
        do{
            // Tour de quel joueur
            j=actuelJoueur();
            // Partie
            colonneChoisie = partie(j);
            i++;
        }while(!estGagne(colonneChoisie-1, j));
        System.out.println(this.grille);
        this.partie--;
        this.vainqueur = actuelJoueur().toString();
        System.out.println("Bravo "+this.vainqueur+" tu as gagné !!!");
    }
    
    public int partie(Adversaire j){
        o.println("\n---------------"+j.getPrenom()+"---------------");
        o.println(this.grille);
        return j.choisirColonne(this);

    }
    
    public int getLigne(int colonne){
        String[][] grille =this.grille.getGrille();
        int ligne = 0;
        while(ligne <=(grille.length-1) && grille[ligne][colonne]=="0"){
            ligne++;
        }
        return ligne-1;
    }


    
    public Adversaire actuelJoueur(){
        if(this.partie%2==0){
            this.partie++;
            return  this.getJoueur();
        }
        else{
            this.partie++; 
            return this.getAdversaire();
        } 
    }


    
    public boolean estGagne(int colonne, Adversaire j){
        int ligne = this.getLigne(colonne);        
        this.grille.updateGrille(j.getPion(), ligne, colonne);
        return gagneHorizontale(ligne, colonne, j) || gagneVerticale(ligne, colonne, j) || gagneDiagonale(ligne, colonne, j);
    }

    public boolean gagneDiagonale(int ligne, int colonne, Adversaire j){
        int compteurDiagonale1 = 0;
        int compteurDiagonale2 = 0;
        String[][] grille = this.grille.getGrille();
        int i=ligne;
        int k=colonne;

        //en bas a droite
        while(i<6 && k<7 && grille[i][k]==j.getPion()){
            compteurDiagonale1++;
            i++;
            k++;
        }

        //en bas a gauche
        i=ligne+1;
        k=colonne-1;
        while(i<6 && k>=0 && grille[i][k]==j.getPion()){
            compteurDiagonale2++;
            i++;
            k--;
        }

        //en haut a droite
        i=ligne-1;
        k=colonne+1;
        while(i>=0 && k<7 && grille[i][k]==j.getPion()){
            compteurDiagonale2++;
            i--;
            k++;
        }

        //en haut a gauche
        i=ligne-1;
        k=colonne-1;
        while(i>=0 && k>=0 && grille[i][k]==j.getPion()){
            compteurDiagonale1++;
            i--;
            k--;
        }

        return compteurDiagonale2>=4 || compteurDiagonale1>=4;
    }


    public boolean gagneVerticale(int ligne, int colonne, Adversaire j){

        int compteur = 0;
        String[][] grille = this.grille.getGrille();
        int i=ligne;

        //en bas
        while(i<6 && grille[i][colonne]==j.getPion()){
            compteur++;
            i++;
        }

        //en haut
        i=ligne-1;
        while(i>=0 && grille[i][colonne]==j.getPion()){
            compteur++;
            i--;
        }

        return compteur>=4;
    }


    public boolean gagneHorizontale(int ligne, int colonne, Adversaire j){

        int compteur = 0;
        String[][] grille = this.grille.getGrille();
        int i=colonne;

        //a droite
        while(i<7 && grille[ligne][i]==j.getPion()){
            compteur++;
            i++;
        }

        //a gauche
        i=(colonne-1);
        while(i>=0 && grille[ligne][i]==j.getPion()){
            compteur++;
            i--;
        }
            
        return compteur>=4;
    }

    public Adversaire getJoueur(){
        return this.joueur;
    }

    public Adversaire getAdversaire(){
        return this.adversaire;
    }

    public String getVainqueur(){
        return this.vainqueur;
    }



}
