import java.io.PrintStream;
import java.util.Scanner;
public class coodemaroc {
    public static PrintStream output = new PrintStream(System.out);
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        // output.println(message());
        // output.println(produit());
        // output.println(echange_entiers());
        // output.println(pair_impair());
        // output.println(max_3_chiffres());
        // output.println(valide());
        // output.println(neg_pos());
        // output.println((moy()));
        // output.println((prix()));
        // output.println((facture_photos()));
        // output.println((categorie()));
        // output.println((mois()));
        // bonjour10fois();
        // output.println((somme_jusqu_a(10)));
        // table_nb(178);
        output.println((stock_values()));


    }

    public static String message(){
        //exo1
        return "Bonjour";
    }

    public static int[] stock_values(){
        //exo25
        int[] tab=new int[10];
        for(int i=0;i<10;i++){
            output.println("Entrez un entier");
            tab[i]=input.nextInt();
            
        }
        return tab;
    }


    public static void table_nb(int nb){
        //exo18
        for(int i=0; i<=10;i++){
            output.println(i*nb);
        }
    }

    public static int somme_jusqu_a(int nb){
        //exo15,16,18,19
        int somme=0;
        int i=0;
        while(i<nb){
            somme+=i+1;
            i++;
        }
        return somme;
    }

    public static void bonjour10fois(){
        //exo14,17
        int i=0;
        while(i<10){
            output.println("Bonjour");
            i++;
        }
    }


    public static String mois(){
        //exo13
        output.println("Saissisez le nombre du mois :");
        int nb_mois=input.nextInt();
        String[] mois= {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Aout", "Septembre", "Octobre", "Novembre", "Décembre"};
        if(nb_mois<1 || nb_mois>13) return "le chiffre n'est pas valide";
        return mois[nb_mois-1];
    }

    public static String categorie(){
        //exo12
        output.println("Entrez l'âge de l'enfant entre 6 et 17 ans inclus");
        int age= input.nextInt();
        if(age<=7){
            return "Poussins";
        }else if(age<=9){
            return "Pupille";
        }
        else if(age<=11){
            return "Minime";
        }
        else{
            return "Cadet";
        }
    }

    public static double facture_photos(){
        //exo11
        output.println("Entrez le nombre de photocopies effectuées :");
        double nb=input.nextDouble();

        if(nb<=10){
            return nb*0.25;
        }
        else if(nb<=30){
            return 10*0.25+(nb-10)*0.2;
        }
        else{
            return 10*0.25+(nb-10)*0.2+(nb-30)*0.1;
        }
    }
   
    public static double prix(){
        //exo10
        output.println("Saissez le prix HT :");
        double prix_ht=input.nextDouble();
        double final_price=0;
        if (prix_ht>200){
            final_price=prix_ht-prix_ht*0.15;
        }
        return final_price+final_price*0.2;
    } 


    public static float moy(){
        //exo9
        output.println("Entre la première note :");
        float note1=input.nextFloat();
        output.println("Entre la duxième note :");
        float note2=input.nextFloat();
        output.println("Entre la troisième note :");
        float note3=input.nextFloat();

        return (note1+note2+note3)/3;
    }

    public static int valeur_absolue(){
        //exo8
        output.println("Entrez un entier :");
        int entier=input.nextInt();
        return Math.abs(entier);
    }

    public static String neg_pos(){
        //exo7
        output.println("Saisi un premier facteur");
        float nb1= input.nextFloat();
        output.println("Saisi un deuxième facteur");
        float nb2= input.nextFloat();
        if (nb1*nb2>0){
            return "Le produit est positif";
        }
        else if (nb1*nb2<0){
            return "Le produit est négatif";
        }
        return "Le produit est nul";

    }


    public static String valide(){
        //exo6
        float note;
        do{
            output.println("saisi ta note");
            note= input.nextFloat();

        }while(note>20 || note<0);

        if(note>=10){
            return "Validé";
        }
        return "Non validé";
    }

    

    public static int max_3_chiffres(){
        //exo5
        output.println("Entre un premier nombre int");
        int nb1= input.nextInt();
        output.println("Entre un deuxième nombre int");
        int nb2= input.nextInt();
        output.println("Entre un troisième nombre int");
        int nb3= input.nextInt();
        int max=Math.max(nb1, nb2);
        return Math.max(max, nb3);
    }


    public static float produit(){
        //exo2
        output.println("Entre un premier nombre");
        float facteur1= input.nextFloat();
        output.println("Entre un deuxième nombre");
        float facteur2= input.nextFloat();

        return facteur1*facteur2;
    }

    public static String echange_entiers(){
        //exo3
        output.println("Entre int a");
        int a=input.nextInt();
        output.println("Entre int b");
        int b=input.nextInt();
        int c=a;
        a=b;
        b=c;
        return "a = "+a+" b = "+b;
    }

    public static boolean pair_impair(){
        //exo4
        output.println("Entre un nombre entier :");
        int answer=input.nextInt();
        return answer%2==0;
    }
}
