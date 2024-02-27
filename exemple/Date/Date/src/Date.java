public class Date implements Comparable<Date>{

    /*********************************************
     *** Attributs
     *********************************************/
    protected int jour;
    protected int mois;
    protected int an;

     /*********************************************
     *** Constructeurs
     *********************************************/
    public Date(int jour, int mois, int an){
        if(!Date.verifier(jour, mois, an)){
            System.out.println("La date "+jour+"/"+mois+"/"+an+"  n'est pas valide");
        }
        this.setAn(an);
        this.setMois(mois);
        this.setJour(jour);
    }

    public Date(int an, int numJourAnnee){
        if(numJourAnnee>An.nbJoursAnnee(an)){
            System.out.println("Le nombre de jours est trop élevé");
            System.exit(1);
        }else{
            this.setAn(an);
            int[] tab_jour_mois = An.nbJoursMois(an);
            int i=0;
            while(tab_jour_mois[i]<numJourAnnee){
                this.setMois(i+1);
                numJourAnnee-=tab_jour_mois[i];
                i++;
            }
        
            this.setMois(this.mois+1);
            this.setJour(numJourAnnee);
        }
    }

    public Date(){
        this.jour=0;
        this.mois=0;
        this.an=0;
    }

     /*********************************************
     *** Accesseurs / mutateurs
     *********************************************/

    
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
                System.out.println("The day has to be between 1 and the number of days in the month "+this.nomMois()+".");
                System.exit(1);
            }
        }
        else{
            System.out.println("You have to set a month and the year before setting a day. Please retry when the month and the year will be set.");
            System.exit(1);
        }
    }

      /*********************************************
     *** Méthodes
     *********************************************/

    public String toString(){
        // System.out.println(""+this.nomJourSemaine()+" "+this.jour+" "+this.nomMois()+" "+this.an);
        if(this.jour==1 && this.mois==1) System.out.println("J'dis pas bonne année moi loool");
        return ""+this.nomJourSemaine()+(this.jour<10?" 0":" ")+this.jour+" "+this.nomMois()+" "+this.an;
    }

    public Date jourDeLAn(){
        return new Date(1, 1, this.an);
    }

    public int compareTo(Date date){
        return this.comparer(date);
    }
    
    public static boolean verifier(int j,int m, int a){
        return m>=1 && m<=12 && j>=1 && j<=An.nbJoursMois(m, a);
    }

    public int numJourAnnee(){
        int nb_jours=this.jour;
        int[] jours_mois=An.nbJoursMois(this.an);
        for(int i=0;i<this.mois-1;i++){
            nb_jours += jours_mois[i];
        }
        return nb_jours;
    }

    public int numJourSemaine(){
        int d = this.jour;
        int m= this.mois;
        int y=this.an;
        return (23*m/9 + d + (m<3?4:2) + y + (m<3?y-1:y)/4 - (m<3?y-1:y)/100 + (m<3?y-1:y)/400 )%7;
    }

    public String nomJourSemaine(){
        String[] jours= {"Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"};
        return jours[this.numJourSemaine()];
    }

    public int comparer(Date d1){
        if(this.jour==d1.getJour() && this.mois==d1.getMois() && this.an == d1.getAn()){
            return 0;
        }
        else if(this.an < d1.an){
            return -1;
        }
        else if(this.an > d1.an){
            return 1;
        }
        else if(this.mois <d1.mois){
            return -1;
        }
        else if(this.mois > this.mois){
            return 1;
        }
        else if(this.jour <d1.jour){
            return -1;
        }
        else{
            return 1;
        }
        
    }

    public boolean avant(Date d1) {
        return this.comparer(d1)==-1;
    }

    public boolean apres(Date d1) {
        return this.comparer(d1)==1;
    }

    public Date min(Date d1){
        return this.avant(d1)?this:d1;
    }

    public Date max(Date d1){
        return this.apres(d1)?this:d1;
    }
    
    public int difference(Date d1){
        // int jours_an_diff=0;
        
        // if(this.apres(d1)){
        //     if(this.an != d1.an){
        //         for(int i=0; i<(this.an-d1.an);i++){
        //             jours_an_diff+=An.nbJoursAnnee(d1.an+i) ;
        //         }
        //     }
        //     return this.numJourAnnee()-d1.numJourAnnee()+jours_an_diff;
        // }
        // else{
        //     if(this.an != d1.an){
        //         for(int i=0; i<(d1.an-this.an);i++){
        //             jours_an_diff+=An.nbJoursAnnee(this.an+i) ;
        //         }
        //     }
        //     return d1.numJourAnnee()-this.numJourAnnee()+jours_an_diff;
        // }

        int nb_jours=0;
        for(int i=this.min(d1).an;i<this.max(d1).an;i++){
            nb_jours+=An.nbJoursAnnee(i);
        }
        return nb_jours+this.max(d1).numJourAnnee()-this.min(d1).numJourAnnee();
    }

    public String nomMois(){
        String[] mois={"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre", "Octobre", "Novembre", "Décembre"};
        return mois[this.mois-1];
    }

    
    

    

    

    


    

    

    

    


    

}
