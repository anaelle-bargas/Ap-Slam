import java.util.*;
import java.io.*;
public class An {

    public static boolean estBissextile(int an){
        return (an%400==0 && an%4000!=0) || (an%4==0 && an%100!=0);
    }
    public static int nbJoursAnnee(int an){
        if (estBissextile(an)){
            return 366;
        }
        return 365;
    }
    public static int[] nbJoursMois(int an){
        int[] nb_jours= new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (estBissextile(an)){
            nb_jours[1]=29;
        }
        return nb_jours;
    }
    public static int nbJoursMois(int mois, int an){
        return nbJoursMois(an)[mois-1];
    }

}
