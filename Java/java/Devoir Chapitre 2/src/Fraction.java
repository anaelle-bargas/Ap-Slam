public class Fraction {
    private int num;
    private int dem;

    public int getNum(){
        return this.num;
    }

    public int getDem(){
        return this.dem;
    }

    public void setNum(int num){
        this.num = num;
    }

    public void setDem(int dem){
        if(dem!=0){
            this.dem = dem;
        } 
        else{
            System.out.println("Le denominateur ne peut etre egal a 0, veuillez réessayer");
        }
    }

    public Fraction(){
        this.setNum(0);
        this.setDem(1);
    }

    public Fraction(int num){
        this.setNum(num);
        this.setDem(1);
    }

    public Fraction(int num, int dem){
        if(num!=0 && dem!=0){
            int pgcd=Entier.PGCD(num, dem);
            this.setNum(num/pgcd);
            this.setDem(dem/pgcd);
        }
        else{
            //dans le cas ou le numérateur est à 0, ou le dénominateur PGCD ne fonctionne pas
            this.setNum(num);
            this.setDem(dem);
        }
    }

    public void afficher(){
        System.out.println(this.getNum()+((this.getDem()==1)?"":"/"+this.getDem()));
    }

    public Fraction additionner(Fraction f2){
        int a = this.getNum();
        int b = this.getDem();
        int c = f2.getNum();
        int d = f2.getDem();
        Fraction result = new Fraction(a*d+c*b, b*d);
        return result;
    }

    public Fraction multiplier(Fraction f2){
        int a = this.getNum();
        int b = this.getDem();
        int c = f2.getNum();
        int d = f2.getDem();
        Fraction result = new Fraction(a*c, b*d);
        return result;
    }

    public Fraction oppose(){
        int a = this.getNum();
        int b = this.getDem();
        Fraction result = new Fraction(-a, b);
        return result;
    }

    public Fraction inverse(){
        int a = this.getNum();
        int b = this.getDem();
        Fraction result = new Fraction(b, a);
        return result;
    }


    public Fraction soustraire(Fraction f2){
        Fraction result = this.additionner(f2.oppose());
        return result;
    }

    public Fraction division(Fraction f2){
        Fraction result = this.multiplier(f2.inverse());
        return result;
    }

    public int comparer(Fraction f2){
        int a = this.getNum();
        int b = this.getDem();
        int c = f2.getNum();
        int d = f2.getDem();

        return ((a*d)!=(b*c))?(((a*d)<(b*c))?-1:1):0;
    }

}
