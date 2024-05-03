public class Evenement extends Date{
    private String nomEvenement;
    private Date date = new Date();
    public Evenement(Date date, String nomEvenement){
        super(date.getJour(), date.getMois(), date.getAnnee());
        this.nomEvenement = nomEvenement;
    }

    public String getNomEvenement(){
        return this.nomEvenement;
    }


    public String toString(){
        return super.toString()+": "+this.getNomEvenement();
    }

    public boolean egale(Evenement e){
        return this.getNomEvenement() == e.getNomEvenement() && super.egale(e);
    } 
}
