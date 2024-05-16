public class Reel extends Affichage implements IOperation{
    private double x;

    public Reel(double x){
        this.x=x;
    }

    public Object plus(Object obj){
        return obj;
    }
    public Object moins(Object obj){
        return obj;
    }

    public String affiche(){
        return ""+this.x;
    }
}
