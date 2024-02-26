import java.io.PrintStream;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;


public class age {
    public static PrintStream output = new PrintStream(System.out);
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        // output.println(age());
        // output.println(fahrenheit(20.089f));
        // output.println(factorielle(5));
        // output.println(perimetre(20.0f, 20.0f));
        // output.println(aire(20.0f, 20.0f));
        // output.println(estPair(22));
        // output.println(authentification("ananas", "ananas29"));
        // output.println(parc(16, 18));
        // output.println(categorie(65));
        // carresParfaits(100);
        // multiplications(6);
        // output.println(estPremier(-1));
        // output.println(civilite());
        // deviner();
        // int[] tab = {1, 2, 3, 4, 5, 6};
        // output.println(inverser(tab));
        // int[] tab1 = {1,2,3,4,5};
        // int[] tab2 = {1,2,3,4,5};
        // output.println(egaux(tab1, tab2));
        // int[][] tab = {
        //     {12,10,5},
        //     {2,9,16},
        //     {13,8,6},
        // };
        // output.println(carreMagique(tab));
        // int[] notes = {19, 18, 18};
        // int[] coeffs = {2, 1, 1};
        // output.println(moyenne(notes, coeffs));
        // String[] adn1= {"A", "A", "T", "G", "G", "C"};
        // String[] adn2= {"C", "T", "A", "C", "A", "G"};
        // output.println(taux_concordance(adn1, adn2));

        // output.println(estBissextile(2000));
        // output.println(jourMois(1, 2001));
        deviner_2();
    }
    public static void carre_magique_2(){

    }
    public static void deviner_2(){
        // int nb_random = Math.random()*1000;
        int nb_random=(int) (Math.random()*999)+1;
        int answer=0;
        while(answer != nb_random){
            output.println("Entrez un nombre entre 0 et 1000");
            answer=input.nextInt();
            if(answer<nb_random){
                output.println("TropPetit");
            }
            else if(answer>nb_random){
                output.println("TropGrand");
            }
            else{
                output.println("Gagné !");
            }
        }
    }
    public static char civilite_2(){
        char answer;
        do{
            output.println("Etes-vous un homme ou une femme ? \nEntrez 'H' ou 'F' :");
            answer=input.nextLine().toUpperCase().charAt(0);
        } while(answer!='H' && answer != 'F');
        return answer;
    }

    public static String jourMois(int jour, int annee){
        int nbMax= estBissextile(annee) ? 366 : 365;

       
        if(jour<=0 || jour > nbMax){
            return "Ce jour n'existe pas";
        }
    
        int[] jourParMois = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31,30, 31};
        if(estBissextile(annee)){
            jourParMois[1]=29;
        }
        int mois = 0;
        while (jour >jourParMois[mois]){
            mois++;
            output.println((mois));
            if(jour > jourParMois[mois-1]){
                jour-=jourParMois[mois-1];
            }
        }
        return jour+"/"+(mois+1);

    }

    public static Boolean estBissextile(int annee){
        return (annee%4==0 && annee%100!=0) || (annee%400==0 && annee%4000!=0);
    }

    public static Float taux_concordance(String[] adn1, String[] adn2){
        int nb_bases_appariees = 0;
        for(int i=0; i<adn1.length;i++){
            if (((adn1[i]=="A" && adn2[i]=="T") || (adn1[i]=="T" && adn2[i]=="A")) || ((adn1[i]=="C" && adn2[i]=="G") || (adn1[i]=="G" && adn2[i]=="C"))){
                nb_bases_appariees++;
            }
        }
        return ((float) nb_bases_appariees/ (float) adn1.length)*100;
    }

    public static Float moyenne(int[] notes, int[] coeff){
        float somme=0;
        float nb_notes=0;
        for(int i=0; i<notes.length;i++){
            somme+=notes[i]*coeff[i];
            nb_notes+=coeff[i];
        }
        return somme/nb_notes;
    }
    
    public static Boolean carreMagique(int[][] tab){
        int somme_values = 0;
        int somme_values_ligne = 0;
        int somme_values_colonne = 0;
        int somme_diagonale1 =0;
        int somme_diagonale2=0;

        for(int i=0;i<tab.length;i++){
            somme_values+=tab[0][i];
        }
        for(int i=0;i<tab.length;i++){      
            somme_values_ligne=0;
            somme_values_colonne=0;     
            for(int j=0;j<tab.length;j++){
                somme_values_ligne+=tab[i][j];
                somme_values_colonne+=tab[j][i];                
                if(i==j){
                    somme_diagonale1+=tab[i][j];
                    somme_diagonale2+=tab[i][tab.length-j-1];
                }
            }
            if(somme_values_ligne!=somme_values || somme_values_colonne != somme_values){
                return false;
            }
            
        }

        if(somme_diagonale1!=somme_values || somme_diagonale2!=somme_values){
            return false;
        }
        return true;
    }

    public static Boolean egaux(int[] tab1, int[] tab2){
        if(tab1.length == tab2.length){
            for(int i=0; i<tab1.length;i++){
                if(tab1[i]!=tab2[i]){
                    return false;
                }
            }
            return true;
        }
        else{
            return false;
        }
    }

    public static String inverser( int[] tab){
        int der_valeur;
        for(int i = 0; i<=(tab.length/2)-1; i++){
            der_valeur = tab[tab.length-i-1];
            tab[tab.length-i-1]=tab[i];
            tab[i] = der_valeur;
        }
        return Arrays.toString(tab);
    }

    public static String deviner(){
        int answer;
        Random randomGenerator = new Random();
        int nb = randomGenerator.nextInt(1000)+1;
        do{
            output.println("Devine un nombre entier entre 1 et 1000 : ");
            answer = input.nextInt();
            if(answer < nb){
                output.println("Trop petit !");

            }
            else if(answer>nb){
                output.println("Trop grand !");
            }
        }while(answer!=nb);
        return "Gagne !";
    }

    public static Character civilite(){
        char answer;

        do {
            output.println("Etes-vous un homme ou une femme ? Repondez soit H, soit F");
            answer = input.nextLine().toUpperCase().charAt(0);
            
        } while (answer != 'H' && answer != 'F');
        
        
        
        return answer;

    }

    public static Boolean estPremier(int nb){
        if(nb>=0){
            Double sr= Math.sqrt(nb);
            for(int i =2;i<=sr;i++){
                if(nb % i == 0){
                    return false;
                }
            }
            return true;
        }
        else{
            output.println("Le nb entré en paramètres doit être un entier positif");
            System.exit(1);
        }
        return false;
    }

    public static void age(){
        output.println("Saisir ton nom");
		String nom=input.nextLine();

        output.println("Saisir ton prenom");
		String prenom=input.nextLine();

        output.println("Saisir ton année de naissance");
		int annee_naissance=input.nextInt();

        output.println("Saisir l'annee que tu veux savoir");
		int annee_a_trouver=input.nextInt();

        int age = annee_a_trouver - annee_naissance;

        output.println("Hi "+prenom+" "+nom+", in "+annee_a_trouver+" you'll be "+age+" years old !");
        output.close();
        input.close();
    }


    public static float fahrenheit(float celsius){
        return 9*celsius/5+32;
    }

    public static float perimetre(float largeur, float longueur){
        return (longueur+largeur)*2;
    }

    public static float aire(float largeur, float longueur){
        return longueur*largeur;
    }

    public static boolean estPair(int nb){
        return nb%2==0;
    }

    public static String authentification(String login, String mdp){
        String real_login = "ananas";
        String real_mdp = "ananas29";

        if(real_login==login && real_mdp==mdp){
            return "Login Win !";
        }else{
            return "Please, try again";
        }
    }

    public static float parc(int age, int heure_arrivee){
        float prix=0;
        if(9<=heure_arrivee&& heure_arrivee<19){
            if(age>=5){
                int heures_restantes = 19 - heure_arrivee;
                prix=(6+2*heures_restantes)>18 ? 18:(6+2*heures_restantes);
            }
        }
        else{
            output.println("L'heure n'est pas valide");
            System.exit(1);
        }
        return prix;
    }

    public static String categorie(int age){
        if(age<8){
            return "Petits poussins";
        }
        else if(age<10){
            return "Poussins";
        }
        else if(age<12){
            return "Pupilles";
        }
        else if(age<14){
            return "Benjamins";
        }
        else if(age<16){
            return "Minimes";
        }
        else if(age<18){
            return "Cadets";
        }
        else if(age<20){
            return "Juniors";
        }
        else if(age<50){
            return "Seniors";
        }
        else if(age<65){
            return "Seniors +";
        }
        else{
            return "Vétérans";
        }
    }


    public static void carresParfaits(int nb){
        int chiffre_impair = 1;
        for(int i=1; i<=nb; i+=chiffre_impair){
            output.println(i);
            chiffre_impair+=2;
        }
    }


    public static void multiplications(int nb){
        if(nb>=1 && nb<=12){
            for(int i=0; i<=10; i++){
                output.println(nb*i);
            }
        }else{
            output.println("le nb mis en argment doit êre compris entre 1 et 12");
        }
    }


    public static int factorielle(int nb){
        int facto=1;
        if(nb >=2){
            for(int i=2; i<=nb; i++){
                    facto*=i;
            }
        }
        else{
            output.println("un nombre entier positif");
            System.exit(1);
        }
        return facto;
    }
    
}
