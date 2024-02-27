import java.util.ArrayList;
import java.util.Collections;

public class Programme {
    public static void main(String[] args) throws Exception {
        // Date date1=new Date(27, 2, 2024);
        // Date date2=new Date(26, 12, 2025);
        // Date date3=new Date(14, 7, 2023);
        // Date date4=date1.jourDeLAn();
        // Date date5= new Date(2023, 195);
        // Date date6= new Date(2, 3, 2005);
        // Date date7= new Date(15, 9, 2008);

        // System.out.println(date1.getJour());
        // System.out.println(date1.getMois());
        // System.out.println(date1.getAn());
        // System.out.println(An.nbJoursMois(date1.getAn()));
        // date3.afficher();
        // date4.afficher();
        // date2.afficher();
        // date1.afficher();
        // System.out.println(date4.egale(date3));
        // System.out.println(date3.numJourAnnee());
        // date5.afficher();
        // date6.afficher();
        // System.out.println(date7.numJourSemaine());
        // System.out.println(date7.nomJourSemaine());
        // System.out.println(date7.comparer(date6));
        // System.out.println(date7.avant(date6));
        // System.out.println(date7.apres(date6));
        // System.out.println(date7.egale(date6));
        // System.out.println("date 7");
        // date7.afficher();
        // System.out.println("date 6");
        // date6.afficher();
        // System.out.println(date6.apres(date7));
        // System.out.println(date6);


        // Evenement e1=new Evenement();
        // Evenement e2=new Evenement();
        // e1.setAn(2024);
        // e1.setMois(8);
        // e1.setJour(23);
        // e1.setNomEvenement("assemblée internationale");
        // System.out.println(e1.egale(e2)); 
        // System.out.println(e1); 

        ArrayList<Date> lesDates = new ArrayList<Date>();
        lesDates.add(new Date(27, 12, 2024));
        lesDates.add(new Date(17, 2, 2024));
        lesDates.add(new Date(27, 2, 2024));
        lesDates.add(new Evenement("bla", 25, 2, 2024));
        lesDates.add(new Evenement("blou", 23, 2, 2024));

        Collections.sort(lesDates);
        for(Date uneDate: lesDates){
            System.out.println(uneDate);
        }

    }
}
