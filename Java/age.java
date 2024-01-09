import java.io.PrintStream;
import java.util.Scanner;

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
        multiplications(6);

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
            output.println("le nb mis en argment doit êre compris entre 1 et 12");
        }


    }
    
}
