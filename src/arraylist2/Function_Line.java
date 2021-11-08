package arraylist2;

public class Function_Line extends Function implements Cloneable {

    private double k, q;
    private double result;

    Function_Line() {
        this.k = 1.0;
        this.q = 1.0;
    }

    Function_Line(double k, double q) {
        this.k = k;
        this.q = q;
    }

    @Override
    public String getType() {
        return "line";
    }

    public double calc_y(double x) {
        return this.k * x + this.q;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Function_Line other = (Function_Line) obj;
        if (Double.doubleToLongBits(k) != Double.doubleToLongBits(other.k) && Double.doubleToLongBits(q) != Double.doubleToLongBits(other.q))
            return false;
        return true;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        Function_Line newobj = new Function_Line(this.k, this.q);
        return newobj;

    }

    @Override
    public String toString() {
        return "k = [" + k + "] q = [" + q + "]";
    }

}
