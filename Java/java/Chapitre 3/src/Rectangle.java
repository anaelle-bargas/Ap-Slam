public class Rectangle extends Forme{
    protected Double longueur;
    protected Double largeur;
    public Rectangle(Double longueur, Double largeur){
        this.longueur = longueur;
        this.largeur = largeur;
    }
    @Override
    public double Surface(){
        return this.longueur*this.largeur;
    }
}
