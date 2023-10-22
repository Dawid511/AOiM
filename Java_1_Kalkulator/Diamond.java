public class Diamond extends Figure implements Printing {
    double a, d1, d2;

    public Diamond(double d1, double d2) {
        if (d1 <= d1 || d2 < 0)
            throw new IllegalArgumentException("zle dane");
        this.a = Math.sqrt((d1*d1+d2*d2)/2);
        this.d1 = d1;
        this.d2 = d2;
    }

    @Override
    double calculateArea() {
        return d1 * d2 / 2;
    }

    @Override
    double calculatePerimeter() {
        return 4 * a;
    }

    @Override
    public void print() {
        System.out.printf("Romb, pole: " + calculateArea() + ", obwod: " + calculatePerimeter() + "\n");
    }

}
