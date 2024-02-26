import java.io.PrintStream;
import java.util.Scanner;

public class Ville {

    public static PrintStream o = new PrintStream(System.out);
    public static Scanner i = new Scanner(System.in);

    private String nomVille;
    private String nomPays;
    private int nbreHabitants;
    private char categorie;
    private static int nbreVilles;

    public static int getNbreVilles(){
        return nbreVilles;
    }
    
    public Ville(){
        System.out.println("Création d'une ville !");
        this.nomVille = "Inconnu";
        this.nomPays = "Inconnu";
        this.nbreHabitants = 0;
        this.setCategorie();
        nbreVilles++;
    }


    public Ville(String nomVille, String nomPays, int nbreHabitants){
        System.out.println("Création d'une ville !");
        this.nomVille = nomVille;
        this.nomPays = nomPays;
        this.nbreHabitants = nbreHabitants;
        this.setCategorie();
        nbreVilles++;
    }

    public String description(){
        return this.getNomVille()+" est une ville de "+this.getNomPays()+", elle comporte : "+this.getNbreHabitants()+" habitant(s) => elle est donc de catégorie : "+this.getCategorie();
    }

    public String description(Ville v1){
        return this.description()+" \n"+v1.description()+"\n"+this.comparer(v1);
    }

    public String comparer(Ville v1){
        String str= new String();
        if(v1.getNbreHabitants() > this.getNbreHabitants()){
            str=v1.getNomVille()+" est une ville plus peuplée que "+this.getNomVille();
        }
        else{
            str=v1.getNomVille()+" est une ville moins peuplée que "+this.getNomVille();
        }
        return str;
    }

    public char getCategorie(){
        return this.categorie;
    }

    private void setCategorie(){
        int bornesSup[]={0, 1000, 10000, 100000, 1000000, 5000000, 10000000};
        char categories[] = {'?', 'A', 'B', 'C', 'D', 'F', 'G', 'H'};
        int i=0;
        while(i<bornesSup.length && this.nbreHabitants > bornesSup[i]) i++;
        this.categorie=categories[i];

        
    }


    public String getNomVille(){
        return this.nomVille;
    }

    public String getNomPays(){
        return this.nomPays;
    }

    public int getNbreHabitants(){
        return this.nbreHabitants;
    }

    public void setNomVille(String nomVille){
        this.nomVille= nomVille;
    }

    public void setNomPays(String nomPays){
        this.nomPays=nomPays;
    }

    public void setNbreHabitants(int nbreHabitants){
        this.nbreHabitants=nbreHabitants;
    }

}
