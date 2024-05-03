import java.io.PrintStream;
import java.util.Scanner;

public class App {
    public static PrintStream o = new PrintStream(System.out);
    public static Scanner i = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        o.println("JourMois : " + jourMois(195,2023));
        String[] a1 = {"A", "A", "T", "G", "G", "C"};
        String[] a2 = {"C", "T", "A", "C", "A", "G"};

        o.println("taux_concordance : " + taux_concordance(a1, a2));

        float[] n = {15.5f, 14.5f, 16.8f}; 
        float[] c = {5f, 5f, 8f}; 
        o.println("moyenne : "+moyenne(n, c));

        int[][] cm = {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}};
        o.println("CarreMagique :"+carreMagique(cm));

        int[] t = {1, 2, 3, 4, 5};
        inverser(t);
    }

    public static int[] inverser(int[] t){
        for(int i=0;i<=t.length/2;i++){
            int elem = t[i];
            t[i] = t[t.length-i-1];
            t[t.length-i-1] = elem;
        }
        for(int i=0;i<t.length;i++){
            o.println(t[i]);
        }
        return t;
    }

    public static boolean estBissextile(int a){
        return (a%4==0 && a%100!=0) || (a%400==0 && a%4000 !=0);
    }

    public static boolean carreMagique(int[][] c){
        int somme=0;
        int[] sommeColonne = new int[c.length];
        int[] sommeDiagonales = new int[2];
        for(int i =0;i<c[0].length;i++){
            somme+=c[0][i];
        }
        for(int i =0;i<c.length;i++){
            int sommeLigne = 0;
            for(int j=0;j<c[i].length;j++){
                sommeColonne[j] += c[i][j];
                sommeLigne+=c[i][j];
                if(i==j){
                    sommeDiagonales[0]+=c[i][j];
                    sommeDiagonales[1]+=c[c.length-i-1][c.length-j-1];
                }
            }
            //verifier que la somme de la ligne correspond.
            if(sommeLigne != somme){
                return false;
            }
        }
        for(int i=0;i<sommeColonne.length;i++){
            //Vérifier que les sommes de toutes les colonnes correpondent.
            if(sommeColonne[i]!=somme){
                o.println("SOMMECOLONNE :"+sommeColonne[i]);
                return false;
            }
        }
        for(int i=0;i<2;i++){
            //Vérifier que les sommes des 2 diagonales.
            if(sommeDiagonales[i]!=somme){
                return false;
            }
        }
        return true;
    }

    public static String jourMois(int n, int a){
        int[] nbJoursMois = {31, (estBissextile(a)?29:28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int mois=0;
        while(n>nbJoursMois[mois]){
            n-=nbJoursMois[mois];
            mois++;
        }
        return "" + n + "/" + (mois+1) + "/" + a;

    }

    public static float taux_concordance(String[] a1, String[] a2){
        float nbApparie = 0;
        if(a1.length == a2.length){
            for(int i=0;i<a1.length;i++){
                if((a1[i].equals("A") && a2[i].equals("T")) || (a1[i].equals("T") && a2[i].equals("A")) || (a1[i].equals("C") && a2[i].equals("G")) || (a1[i].equals("G") && a2[i].equals("C"))){
                    nbApparie+=1;
                }
            }
            return nbApparie/a1.length*100;
        }
        else{
            o.println("les tableaux entrés ne sont pas de la même taille");
            return 0;
            
        }
    }

    public static float moyenne(float[] n, float[] c){
        float sn = 0;
        float sc = 0;
        for(int i=0; i<n.length;i++){
            sn+=n[i]*c[i];
            sc+=c[i];
        }
        return sn/sc;
    }
}
