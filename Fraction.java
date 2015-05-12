// Fraction class

import java.util.Objects;

class Fraction {

    /**
     * *********** Data members *********************
     */
    private int numer;
    private int denom;

    /**
     * *********** Constructors *********************
     */
    public Fraction() {
        this(1, 1);
    }

    public Fraction(int numer, int denom) {
        setNumer(numer);
        setDenom(denom);
    }

    /**
     * ************* Accessors **********************
     */
    public int getNumer() {
        return numer;
    }

    public int getDenom() {
        return denom;
    }

    /**
     * ************* Mutators ***********************
     */
    public void setDenom(int denom) {
        this.denom = denom;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }

    /**
     * ************** Other methods *****************
     */
    public void simplify() {
        int gcd = gcd(this.getNumer(), this.getDenom());
        this.setDenom(this.getDenom() / gcd);
        this.setNumer(this.getNumer() / gcd);
    }

    private int gcd(int a, int b) {
        if (a == 0 || b == 0) {
            return a + b;
        }
        return gcd(b, a % b);
    }

    public boolean equals(Object fraction) {
        if (fraction instanceof Fraction) {
            Fraction temp = (Fraction) fraction;
            temp.simplify();
            this.simplify();
            return (this.getDenom() == temp.getDenom() && this.getNumer() == temp.getNumer());
        } else {
            return false;
        }
    }

    public Fraction add(Object fraction) {
        Fraction result = new Fraction();
        if (fraction instanceof Fraction) {
            Fraction temp = (Fraction) fraction;
            result.setNumer(this.getNumer() * temp.getDenom() + this.getDenom() * temp.getNumer());
            result.setDenom(this.getDenom() * temp.getDenom());
        }
        result.simplify();
        return result;
    }

    public String toString() {
        return this.getNumer() + "/" + this.getDenom();
    }
}

