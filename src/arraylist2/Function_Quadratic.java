package arraylist2;

public class Function_Quadratic extends Function implements Cloneable {

    double a, b, c;

    Function_Quadratic(){
        this.a = 1.0;
        this.b = 1.0;
        this.c = 1.0;
    }

    Function_Quadratic(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String getType() {
        return "quadratic";
    }

    public double calc_y(double x) {

        return this.a * (x * x) + this.b * x + c;
    }

    public double diskriminant() {
        return b * b - 4 * a * c;
    }

    public int pocet_korenu() {
        if (diskriminant() > 0.0) {
            return 2;
        }
        else if (diskriminant() < 0 ) {
            return 0;
        }
        else return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Function_Quadratic other = (Function_Quadratic) obj;
        if (Double.doubleToLongBits(a) != Double.doubleToLongBits(other.a) && Double.doubleToLongBits(b) != Double.doubleToLongBits(other.b) && Double.doubleToLongBits(c) != Double.doubleToLongBits(other.c))
            return false;
        return true;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        Function_Quadratic newobj = new Function_Quadratic(this.a, this.b, this.c);
        return newobj;

    }

    @Override
    public String toString() {
        return "a = [" + a + "] b = [" + b + "] " + "c = [" + c + "]";
    }
}
