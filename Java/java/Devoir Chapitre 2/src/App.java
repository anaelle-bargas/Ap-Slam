public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("FRACTION 1 :");
        Fraction fractionTest = new Fraction(8, 5);
        fractionTest.afficher();
        
        System.out.println("FRACTION 2 :");
        Fraction fractionTest2 = new Fraction(5);
        fractionTest2.afficher();
        
        System.out.println("ADDITION");
        Fraction addition = fractionTest.additionner(fractionTest2);
        addition.afficher();
        
        System.out.println("MULTIPLICATION");
        Fraction multiplication = fractionTest.multiplier(fractionTest2);
        multiplication.afficher();
        
        System.out.println("OPPOSE");
        Fraction oppose = fractionTest.oppose();
        oppose.afficher();
        
        System.out.println("INVERSE");
        Fraction inverse = fractionTest.inverse();
        inverse.afficher();
        
        System.out.println("SOUSTRACTION");
        Fraction soustraction = fractionTest.soustraire(fractionTest2);
        soustraction.afficher();

        System.out.println("DIVISION");
        Fraction division = fractionTest.division(fractionTest2);
        division.afficher();


        System.out.println("comparaison : "+fractionTest.comparer(fractionTest2));





    }
}
