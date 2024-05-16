public class App {
    public static void main(String[] args) throws Exception {
        Ellipse e1 = new Ellipse(2.0, 3.0);
        Triangle t1 = new Triangle(2.0,3.0);
        Rectangle r1 = new Rectangle(2.0,3.0);
        Carre ca1 = new Carre(2.0);
        Cercle c1 = new Cercle(2.0);
        System.out.println(e1.Surface());
        System.out.println(t1.Surface());
        System.out.println(r1.Surface());
        System.out.println(ca1.Surface());
        System.out.println(c1.Surface());
    }
}
