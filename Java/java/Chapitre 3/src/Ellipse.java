public class Ellipse extends Forme{
    protected Double a;
    protected Double b;

    public Ellipse(Double a, Double b){
        this.a = a;
        this.b = b;
    }

    @Override
    public double Surface(){
        return Math.PI*this.a*this.b;
    }
}
