public class Date {
    private int jour;
    private int mois;
    private int an;

    public Date(int jour, int mois, int an){
        this.setAn(an);
        this.setMois(mois);
        this.setJour(jour);
        boolean valide =this.verifier();
        if(!valide){
            System.out.println("La date que vous venez de créer n'est pas valide");
        }
    }

    public Date(int an, int numJourAnnee){
        // this.setAn(an);
        // this.setMois(mois);
        // this.setJour(jour);
        // boolean valide =this.verifier();
        // if(!valide){
        //     System.out.println("La date que vous venez de créer n'est pas valide");
        // }
    }

    public Date(){
        this.jour=0;
        this.mois=0;
        this.an=0;
    }

    public int numJourAnnee(){
        int nb_jours=0;
        for(int i=0;i<this.mois-1;i++){
            nb_jours += An.nbJoursMois(this.an)[i];
        }
        return nb_jours+this.jour;
    }

    public Date jourDeLAn(){
        return new Date(1, 1, this.an);
    }

    public boolean egale(Date date){
        if(this.an == date.an && this.mois == date.mois && this.jour == date.jour){
            return true;
        }
        return false;
    }

    public boolean verifier(){
        if(this.mois <1 || this.mois >12) return false;
        else if(this.jour<1 || this.jour>An.nbJoursMois(this.mois, this.an)) return false;
        return true;
    }

    public void afficher(){
        if(this.mois<10) {
            if (this.jour<10){
                System.out.println("0"+this.jour+"/0"+this.mois+"/"+this.an);
            }
            else{
                System.out.println(this.jour+"/0"+this.mois+"/"+this.an);
            }
        }
        else {
            if (this.jour<10){
                System.out.println("0"+this.jour+"/"+this.mois+"/"+this.an);
            }
            else{
                System.out.println(this.jour+"/"+this.mois+"/"+this.an);
            }
        }
        if(this.jour==1 && this.mois==1) System.out.println("J'dis pas bonne année moi loool");
    }

    public int getJour(){
        return this.jour;
    }

    public int getMois(){
        return this.mois;
    }

    public int getAn(){
        return this.an;
    }

    public void setAn(int an){
        this.an=an;
    }

    public void setMois(int mois){
        if(this.an !=0){
            if(mois<=12 && mois > 0) this.mois=mois;
            else {
                System.out.println("Le nombre du mois doit être compris entre 1 inclus et 12 inclus");
                System.exit(1);
            }
        }
        else{
            System.out.println("You have to set a year before setting a month. Please retry when the year will be set.");
            System.exit(1); 
        }
    }

    public void setJour(int jour){
        if(this.mois !=0 && this.an !=0){
            if(jour<=An.nbJoursMois(this.mois, this.an) && jour>0){
                this.jour=jour;
            }else{
                System.out.println("The day has to be between 1 and the number of days in the month "+this.mois+".");
                System.exit(1);
            }
        }
        else{
            System.out.println("You have to set a month and the year before setting a day. Please retry when the month and the year will be set.");
            System.exit(1);
        }
    }
}
