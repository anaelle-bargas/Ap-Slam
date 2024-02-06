import java.io.PrintStream;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;


public class age {
    public static PrintStream output = new PrintStream(System.out);
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        // age();
        // fahrenheit(20.089f);
        // perimetre(20.0f, 20.0f);
        // aire(20.0f, 20.0f);
        // estPair(22);
        // authentification("ananas", "ananas29");
        // parc(16, 18);
        // categorie(12);
        // carresParfaits(36);
        // multiplications(6);
        // estPremier(4);
        // civilite();
        // deviner();
        // int[] tab = {1, 2, 3, 4, 5, 6};
        // output.println(inverser(tab));
        // int[] tab1 = {1,2,3,4,5};
        // int[] tab2 = {1,2,3,4,5};
        // output.println(egaux(tab1, tab2));
        int[][] tab = {
            {8,1,6},
            {3,5,7},
            {4,9,2},
        };
        output.println(carreMagique(tab));


    }

    
    public static Boolean carreMagique(int[][] tab){
        int somme_values = 0;
        for(int i=0;i<tab.length;i++){
            somme_values+=tab[0][i];
        }

        for(int i=1;i<tab.length;i++){
            int somme_values_ligne = 0;
            int somme_values_colonne = 0;
            // int somme_diagonale1=tab[0][0]+tab[tab.length-1][tab.length-1];
            // int somme_diagonale2=tab[0][tab.length-1]+tab[tab.length-1][0];
            int somme_diagonale1 =0;
            int somme_diagonale2=0;
            for(int j=0;j<tab.length;j++){
                somme_values_ligne+=tab[i][j];
                somme_values_colonne+=tab[j][i];
                if((i-1)==j){
                    somme_diagonale1+=tab[(i-1)][j];
                    somme_diagonale2+=tab[(i-1)][tab.length-j];
                    output.println(somme_diagonale1);
                    output.println(somme_diagonale2);
                }
            }
            if(somme_values_ligne!=somme_values || somme_values_colonne != somme_values || somme_diagonale1!=somme_values || somme_diagonale2!=somme_values){
                return false;
            }
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
        for(int i = 0; i<=(tab.length/2)-1; i++){
            int prem_valeur = tab[i];
            int der_valeur = tab[tab.length-i-1];
            tab[tab.length-i-1]=prem_valeur;
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
            else{
                return "Gagne !";
            }
        }while(answer!=nb);

        return "";
    }

    public static String civilite(){
        char answer;

        do {
            output.println("Etes-vous un homme ou une femme ? Repondez soit H, soit F");
            answer = input.nextLine().charAt(0);
            
        } while (answer != 'H' && answer != 'F');
        
        
        
        return "Vous etes : "+answer;


    }

    public static Boolean estPremier(int nb){
        if(nb>=0){
            Boolean prime = true;
            Double sr= Math.sqrt(nb);
            for(int i =2;i<=sr;i++){
                if(nb % i == 0){
                    prime=false;
                }
            }
            return prime;
        }
        else{
            output.println("Le nb entré en paramètres doit être un entier positif");
            return false;
        }
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


    public static void fahrenheit(float celsius){
        output.println("En degrés Fahrenheit, "+celsius+"°C = "+9*celsius/5+32);
    }

    public static void perimetre(float largeur, float longueur){
        output.println("Pour une longueur de "+longueur+" et une largeur de "+largeur+", le périmètre sera de : "+(longueur+largeur)*2);
    }

    public static void aire(float largeur, float longueur){
        output.println("Pour une longueur de "+longueur+" et une largeur de "+largeur+", le périmètre sera de : "+longueur*largeur);
    }

    public static void estPair(int nb){
        if(nb%2==0){
            output.println("Le nombre "+nb+" est pair");

        } else{
            output.println("Le nombre "+nb+" est impair");

        }
    }

    public static void authentification(String login, String mdp){
        String real_login = "ananas";
        String real_mdp = "ananas29";

        if(real_login==login && real_mdp==mdp){
            output.println("Login Win !");
        }else{
            output.println("Please, try again");
        }
    }

    public static void parc(int age, int heure_arrivee){
        if(9<=heure_arrivee&& heure_arrivee<=19){
            if(age>=5){
                int heures_restantes = 19 - heure_arrivee;
                float prix=(6+2*heures_restantes)>18 ? 18:(6+2*heures_restantes);
                output.println("Le prix d'entrée sera de : "+prix+"€");
            }
            else{
                output.println("L'enfant n'au rien a payer");
            }
        }
        else{
            output.println("L'heure n'est pas valide");
        }
    }

    public static void categorie(int age){
        if(age<8){
            output.println("Petits poussins");
        }
        else if(age==8||age==9){
            output.println("Poussins");
        }
        else if(age==10||age==11){
            output.println("Pupilles");
        }
        else if(age==12||age==13){
            output.println("Benjamins");
        }
        else if(age==14||age==15){
            output.println("Minimes");
        }
        else if(age==16||age==17){
            output.println("Cadets");
        }
        else if(age==18||age==19){
            output.println("Juniors");
        }
        else if(age>=20 && age<=49){
            output.println("Seniors");
        }
        else if(age>=50 && age<=64){
            output.println("Seniors +");
        }
        else{
            output.println("Vétérans");
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


    public static void factorielle(int nb){
        if(nb>=1 && nb<=12){
            for(int i=0; i<=10; i++){
                output.println(nb*i);
            }
        }else{
            output.println("le nb mis en argument doit êre compris entre 1 et 12");
        }


    }
    
}
