public class Evenement extends Date{
    String nomEvenement;
    Date date = new Date();
    public Evenement(Date date, String nomEvenement){
        this.date = date;
        this.nomEvenement = nomEvenement;
    }
}
