public class Triangle extends Figure implements Printing {
    double a, b, c;

    public Triangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a){
         throw new IllegalArgumentException("zle dane");
        }
            this.a = a;
            this.b = b;
            this.c = c;
    }

    @Override
    double calculateArea() {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    double calculatePerimeter() {
        return this.a + this.b + this.c;
    }

    @Override
    public void print() {
        System.out.printf("Trojkat, pole: " + calculateArea() + ", obwod: " + calculatePerimeter() + "\n");
    }

}
