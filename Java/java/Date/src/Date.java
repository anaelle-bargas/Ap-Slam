import java.util.*;
import java.io.*;

public class Date implements Comparable<Date>{
    protected int jour;
    protected int mois;
    protected int annee;
    
    public static PrintStream o = new PrintStream(System.out);
    public static Scanner i = new Scanner(System.in);
    

    public Date(int jour, int mois, int annee){
        this.setAnnee(annee);
        this.setMois(mois);
        this.setJour(jour);
        if(this.verifier()==false){
            o.println("La date n'ets pas valide");
        }

    }

    public Date(){
        this.jour = 0;
        this.mois = 0;
        this.annee = 0;
    }
    public Date(int numJourAnnee, int annee){
        this.setAnnee(annee);
        ArrayList<Integer> nbJourMois = An.nbJourMois(this.getAnnee());
        int mois =0;
        boolean trouve = false;
        if(numJourAnnee <= An.nbJourAnnee(annee)){

            while(trouve ==false){
                if(numJourAnnee > (nbJourMois.get(mois)) ){
                    numJourAnnee-=nbJourMois.get(mois);
                }
                else{
                    trouve = true;
                }
                mois++;
            }
            this.setMois(mois);
            this.setJour(numJourAnnee);
        }
        else{
            o.println("Le numero du jour n'est pas valide, la date va être automatiquement défini en 1/1/"+this.getAnnee());
            this.setMois(1);
            this.setJour(1);
        }
    }
    
    public int compareTo(Date d){
        return this.comparer(d);
    }

    public int getAnnee(){
        return this.annee;
    }
    public int getMois(){
        return this.mois;
    }
    public int getJour(){
        return this.jour;
    }

    public void setAnnee(int annee){
        this.annee = annee;
    }

    public void setMois(int mois){
        if(mois<=12 && mois>=1){
            this.mois = mois;
        }
        else{
            o.println("le mois doit être compris entre 1 et 12 !");
        }   
    }

    public void setJour(int jour){
        int nbJourMois = An.nbJourMois(this.getAnnee()).get(this.getMois()-1);
        if(this.getMois()==0){
            o.println("Il faut d'abord affecter un mois, avant d'affecter un jour!");
        }
        else if(jour >=1  && jour<=nbJourMois){
            this.jour = jour;
        }
        else{
            o.println("le jour doit être compris entre 1 et le nombre de jours dansle mois. C'est à dire : "+An.nbJourMois(this.getAnnee()).get(this.getMois()-1)+"!");

        }
    }

    public String toString(){
        if(this == this.jourdeLan()){
            o.println("C'est le 1er jour de l'année");
        }
        return ""+this.nomJourSemaine()+" "+(this.getJour()<=9?"0"+this.getJour():this.getJour())+" "+this.nomMois()+" "+this.getAnnee();
    }

    public Date jourdeLan(){
        return new Date(1, 1, this.getAnnee());
    }

    public boolean egale(Date date){
        return this.comparer(date) ==0;
    }

    public int comparer(Date date){
        if(this.annee == date.getAnnee() && this.numJourAnnee() == date.numJourAnnee()){
            return 0;
        }
        else if((this.getAnnee() < date.getAnnee()) || (this.getAnnee() == date.getAnnee() && this.numJourAnnee() < date.numJourAnnee())){
            return -1;
        }
        else{
            return 1;
        }
    }
    
    public boolean avant(Date date){
        return this.comparer(date)==-1;
    }

    public boolean apres(Date date){
        return this.comparer(date)==1;
    }

    public Date min(Date date){
        return this.avant(date)?this:date;
    }

    public Date max(Date date){
        return this.apres(date)?this:date;
    }

    public int difference(Date date){
        int nbJoursEcoules = (this.max(date)).numJourAnnee()-(this.min(date)).numJourAnnee();
        for(int i=this.min(date).getAnnee();i<this.max(date).getAnnee();i++){
            nbJoursEcoules+=An.nbJourAnnee(i);
        }
        return nbJoursEcoules;
    }

    public boolean verifier(){
        int nbJourMois = An.nbJourMois(this.getAnnee()).get(this.getMois()-1);
        return (this.getJour() >=1  && this.getJour()<=nbJourMois) && (mois<=12 && mois>=1);
    }

    public int numJourAnnee(){
        int numJour = 0;
        ArrayList<Integer> nbJourMois = An.nbJourMois(this.getAnnee());
        for(int i=0; i<this.getMois()-1;i++){
            numJour+=nbJourMois.get(i);
        }
        numJour+=this.getJour();
        
        return numJour;
    }

    public int numJourSemaine(){
        return this.getMois()<3?((23*this.getMois()/9)+this.getJour()+4+this.getAnnee()+((this.getAnnee()-1)/4) - ((this.getAnnee()-1)/100) + ((this.getAnnee()-1)/400))%7:((23*this.getMois()/9)+this.getJour()+2+this.getAnnee()+(this.getAnnee()/4) - (this.getAnnee()/100) + (this.getAnnee()/400))%7;
    }

    public String nomJourSemaine(){
        String[] jours ={"Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"};
        return jours[this.numJourSemaine()];
    }

    public String nomMois(){
        String[] mois ={"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Aout", "Septembre", "Octobre", "Novembre", "Décembre"};
        return mois[this.getMois()-1];
    }
}
