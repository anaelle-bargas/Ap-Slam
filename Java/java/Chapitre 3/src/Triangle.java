public class Triangle extends Forme{
    private Double hauteur;
    private Double base;
    public Triangle(Double hauteur, Double base){
        this.hauteur = hauteur;
        this.base = base;
    }
    @Override
    public double Surface(){
        return (this.base*this.hauteur*0.5);
    }
}
