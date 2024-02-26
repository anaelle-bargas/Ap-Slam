public class Programme {
    public static void main(String[] args) throws Exception {
        Date date1=new Date(27, 2, 2024);
        Date date2=new Date(26, 12, 2025);
        Date date3=new Date(14, 7, 2023);
        Date date4=date1.jourDeLAn();
        // System.out.println(date1.getJour());
        // System.out.println(date1.getMois());
        // System.out.println(date1.getAn());
        // System.out.println(An.nbJoursMois(date1.getAn()));
        // date3.afficher();
        // date4.afficher();
        // date2.afficher();
        // date1.afficher();
        // System.out.println(date4.egale(date3));
        // System.out.println(date1.verifier());
        System.out.println(date3.numJourAnnee());


    }
}
