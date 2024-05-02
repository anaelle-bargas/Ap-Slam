import java.util.*;
import java.io.*;
public class An {
    public static boolean estBissextile(int annee){
        return ((annee%4==0 && annee%100!=0) || annee%400==0);
    }

    public static int nbJourAnnee(int annee){
        return estBissextile(annee)?366:365;
    }

    public static ArrayList<Integer> nbJourMois(int annee){
        ArrayList<Integer> nbJourMois = new ArrayList<>();
        for(int i=0;i<12;i++){
            if(i==1){
                nbJourMois.add((estBissextile(annee))?29:28);
            }
            else if(i<=6){
                nbJourMois.add((i%2==0)?31:30);
            }
            else{
                nbJourMois.add((i%2!=0)?31:30);
            }
        }

        return nbJourMois;
    }
}
