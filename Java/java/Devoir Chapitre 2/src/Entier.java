
public class Entier {
    public static int PGCD(int nb1, int nb2){
        nb1 = Math.abs(nb1);
        nb2 = Math.abs(nb2);

        int a = Math.max(nb1, nb2);
        int b= Math.min(nb1, nb2);

        int r = a%b;

        while(r!=0){
            a=b;
            b=r;
            r=a%b;
        }
        return b;
    }
}
