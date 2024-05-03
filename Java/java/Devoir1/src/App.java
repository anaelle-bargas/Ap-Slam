import java.io.PrintStream;
import java.util.Scanner;

public class App {
    public static PrintStream o = new PrintStream(System.out);
    public static Scanner i = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        prix();
        // syracuse(10);
        // chifoumi3();
        // chifoumi2();
        // chifoumi1();
    }


    public static void chifoumi3(){
        String[] elems = {"Pierre", "Feuille", "Ciseaux"};
        int eUser = 0;
        int scoreU = 0;
        int score = 0;
        
        while(score < 3 && scoreU <3){
            int e = (int) (Math.random()*1000)%3;
            o.println(e);
            do{
                o.println("\nPierre(0), Feuille(1), Ciseaux(2)");
                eUser = i.nextInt();
            }while(eUser<0 || eUser>2);
            
            o.println("J'ai joué "+elems[e]);
            o.println("tu as joué "+elems[eUser]);
    
            int win = gagnant(e, eUser);
            if(win == 1){
                o.println("J'ai gagne.");
                score++;
            }
            else if(win == 2){
                o.println("Tu as gagne.");
                scoreU++;
            }
            else{
                o.println("Match nul");
            }
            o.println("Mon score : "+score);
            o.println("Ton score : "+scoreU);
    
        }

    }


    public static void chifoumi2(){
        String[] elems = {"Pierre", "Feuille", "Ciseaux"};
        int eUser = 0;
        int scoreU = 0;
        int score = 0;
        
        for(int j=0;j<3;j++){
            int e = (int) (Math.random()*1000)%3;
            do{
                o.println("\nPierre(0), Feuille(1), Ciseaux(2)");
                eUser = i.nextInt();
            }while(eUser<0 || eUser>2);
            
            o.println("J'ai joué "+elems[e]);
            o.println("tu as joué "+elems[eUser]);
    
            int win = gagnant(e, eUser);
            if(win == 1){
                o.println("J'ai gagne.");
                score++;
            }
            else if(win == 2){
                o.println("Tu as gagne.");
                scoreU++;
            }
            else{
                o.println("Match nul");
            }
            o.println("Mon score : "+score);
            o.println("Ton score : "+scoreU);
    
        }

    }

    public static void chifoumi1(){
        String[] elems = {"Pierre", "Feuille", "Ciseaux"};
        int e = (int) (Math.random()*1000)%3;
        int eUser = 0;
        
        do{
            o.println("Pierre(0), Feuille(1), Ciseaux(2)");
            eUser = i.nextInt();
        }while(eUser<0 || eUser>2);
        
        o.println("J'ai joué "+elems[e]);
        o.println("tu as joué "+elems[eUser]);

        int win = gagnant(e, eUser);
        if(win == 1){
            o.println("J'ai gagne.");
        }
        else if(win == 2){
            o.println("Tu as gagne.");
        }
        else{
            o.println("Match nul");
        }
    }

    public static int gagnant (int j1, int j2){
        return (j1-j2+3)%3;
    }



    public static void syracuse(int n){
        if(n>0){

            while(n>1){
                o.println(n);
                n = (n%2==0)?n/2:n*3+1;
            }
            o.println(n);
        }
        else{
            o.println("n doit être une entier naturel positif");
        }
    }







    public static void prix(){
        int age;
        int annee;
        int mois;
        int jour;

        do{
            o.println("Veuillez saisir l'age de la personne");
            age = i.nextInt();
        }while(age<0 || age>130);
        
        if(age<=5 || age >=65){
            o.println("0");
        }
        else{


            o.println("Veuillez saisir l'annee");
            annee = i.nextInt();
            
            int[] nbJourMois = {31, ((annee%4==0 && annee%100!=0) || (annee%400==0 && annee%4000 !=0))?29:28 ,31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    
            do{
                o.println("Veuillez saisir le mois");
                mois = i.nextInt();
            }while(mois<1 || mois>12);
    
            do{
                o.println("Veuillez saisir le jour");
                jour = i.nextInt();
            }while(jour<1 || jour>nbJourMois[mois-1]);

            if(mois>=6 && mois <=8){
                o.println(age<=25?15:25);
            }
            else if((mois==4 || mois==5) ||(mois==9 || mois==10)){
                o.println(age<=25?10:20);
            }
            else if((jour>=20 && mois==12) || (jour<=10 && mois==1)){
                o.println(age<=25?20:30);
            }
            else{
                o.println(age<=25?5:15);

            }
        }

        
    }

}
