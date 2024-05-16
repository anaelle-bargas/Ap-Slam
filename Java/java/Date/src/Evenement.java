public class Evenement extends Date{
    protected String nomEvenement;
    public Evenement(int j, int m, int a, String nomEvenement){
        super(j, m, a);
        this.nomEvenement = nomEvenement;
    }
    @Override
    public String toString(){
        return ""+super.toString()+": "+this.nomEvenement;
    }

    public String getNomEvenement(){
        return this.nomEvenement;
    }

    public boolean egale(Evenement e2){
        return this.nomEvenement == e2.nomEvenement && super.egale(e2);
    }
}