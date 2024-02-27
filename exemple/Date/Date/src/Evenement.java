public class Evenement extends Date{
    private String nomEvenement;

    public Evenement(){
        this.nomEvenement="";
        this.an=0;
        this.mois=0;
        this.jour=0;
    }

    public Evenement(String e, int j, int m, int a){
        super(j, m, a);
        this.nomEvenement=e;
    }

    public void setNomEvenement(String e){
        this.nomEvenement=e;
    }

    public String getNomEvenement(){
        return this.nomEvenement;
    }

    public boolean egale(Evenement e1){
        return this.an==e1.an && this.mois==e1.mois && this.jour==e1.jour && this.nomEvenement==e1.nomEvenement;    
    }

    public String toString(){
        return ""+new Date(this.jour, this.mois, this.an).toString()+", il y aura l'évènement : "+this.nomEvenement;
    }

    
}
