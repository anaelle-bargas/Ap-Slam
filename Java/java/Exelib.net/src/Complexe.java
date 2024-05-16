public class Complexe extends Affichage implements IOperation{
    private double im;
    private double re;

    public Complexe(double im, double re){
        this.im = im;
        this.re = re;
    }
    public Object plus(Object obj){
        return obj;
    }
    public Object moins(Object obj){
        return obj;
    }

    public String affiche(){
        return ""+this.im+" "+this.re;
    }
}
