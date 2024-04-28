import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {
    public static PrintStream output = new PrintStream(System.out);
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        output.println("Hello, World !");

        //exo 29
        // triTableau();

        // exo30
        // factorielEntier();

        //exo 31
        // nbPaires();

        //exo 32
        // sommeNbImpaires();

        //exo 33
        // output.println(pgcd(60, 36));

        //exo 35
        // nbChiffreSaisis();
        
        //exo 36
        triangleEtoiles();
    }

    public static void triangleEtoiles(){
        output.println("Entre un entier N :");
        int n = input.nextInt();
        int tailleMaxTriangle = n+(n-1);
        for(int i=1; i<=n; i++){
            String chaine = "";
            int nbEtoiles = i+(i-1);
            int nbEspaces = tailleMaxTriangle-nbEtoiles;
            for(int j=1;j<=nbEspaces/2;j++){
                chaine+=" ";
            }
            for(int j=0;j<nbEtoiles;j++){
                chaine+="*";
            }
            for(int j=1;j<=nbEspaces/2;j++){
                chaine+=" ";
            }
            output.println(chaine);
        }
    }

    public static void nbChiffreSaisis(){
        output.println("Entre un nombre entier");
        String n=input.nextLine();
        output.println(n.length());


    }

    public static int pgcd(int m, int n){
        ArrayList<Integer> diviseursM = new ArrayList<>();
        ArrayList<Integer> diviseursN = new ArrayList<>();
        diviseursM.add(1);
        diviseursN.add(1);
        //diviseurs de m
        for(int i=2;i<=m;i++) {
            if(m%i==0){
                diviseursM.add(i);
            }
        }

        for(int i=2;i<=n;i++) {
            if(n%i==0){
                diviseursN.add(i);
            }
        }
        
        ArrayList<Integer> plusPetit = new ArrayList<>();
        ArrayList<Integer> plusGrand = new ArrayList<>();

        if(diviseursM.size()<diviseursN.size()){
            plusPetit = diviseursM;
            plusGrand = diviseursN;
        }
        else{
            plusPetit = diviseursN;
            plusGrand = diviseursM;
        }
        Collections.reverse(plusPetit);
        for(int i : plusPetit){
            if(plusGrand.contains(i)){
                return i;
            }
        }

        return 1;
    }

    public static void sommeNbImpaires(){
        output.println("Entre un entier N :");
        int n = input.nextInt();
        int somme = 0;
        for(int i=1;i<=n;i++){
            if(i%2==1) somme += i;
        }
        output.println(somme);
    }

    public static void nbPaires(){
        output.println("Entre un nombre N :");
        int n = input.nextInt();
        output.println("Les entiers paires entre 0 et "+n+" sont : ");
        for(int i=0;i<=n;i++){
            if(i%2==0){
                output.println(i);

            }
        }
    }

    public static void factorielEntier(){
        output.println("Saisi un entier n");
        int n = input.nextInt();
        int factoriel = 1;
        for(int i=2; i<=n; i++){
            factoriel*=i;
        }
        // output.println(factoriel);
    }

    public static int[] triTableau(){
        //initialisation du tableau
        int[] tableauUser = new int[10];

        //Remplir le tableau
        for(int i=0;i<10;i++){
            output.println("Saisissez l'élément numéro "+i+"du tableau");
            tableauUser[i]=input.nextInt();
        }

        //trier le tableau : recherche du plus petit élément et positionnement dans la tableau a retourner

        int positionActuelle = 0;
        int positionMin = 0;
        while(positionActuelle<10){

            int min = tableauUser[positionActuelle];
            boolean isAMinimum = false;
            
            for(int i=positionActuelle+1; i<10;i++){
                //recherche du plus petit élément
                if(tableauUser[i]<min){
                    min = tableauUser[i];
                    positionMin = i;
                    isAMinimum = true;
                }
                
            }

            if(isAMinimum == true){
                //on échange les valeurs du tableau s'il y a un élément plus petit que l'élément actuel
                tableauUser[positionMin]=tableauUser[positionActuelle];
                tableauUser[positionActuelle] = min;
            }

            positionActuelle++;

        }

        //afficher ce tableau
        String tableauAfficher = "[";
        for(int i=0;i<10;i++){
            if(i<9){
                tableauAfficher+=tableauUser[i]+", ";
            }
            else{
                tableauAfficher+=tableauUser[i];
            }
        }
        tableauAfficher+="]";
        output.println(tableauAfficher);

        return new int[5];
    }
}
