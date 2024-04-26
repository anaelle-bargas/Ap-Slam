import java.util.*;
import java.io.PrintStream;
import java.lang.*;

public class App {
    public static PrintStream output = new PrintStream(System.out);
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        output.println("Hello, World !");
        triTableau();
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
