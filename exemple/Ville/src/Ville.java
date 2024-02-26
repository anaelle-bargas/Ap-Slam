public class Ville {
    private String nomVille;
    private String nomPays;
    private int nbreHabitants;

    public Ville(){
        System.out.println("Création d'une ville !");
        this.nomVille = "Inconnu";
        this.nomPays = "Inconnu";
        this.nbreHabitants = 0;
    }

    public Ville(String nomVille, String nomPays, int nbreHabitants){
        System.out.println("Création d'une ville !");
        this.nomVille = nomVille;
        this.nomPays = nomPays;
        this.nbreHabitants = nbreHabitants;

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
