public class Rectangle extends Figure implements Printing{
    double a, b;
    public Rectangle(double a, double b) {
        if (a <= 0 || b <= 0) 
            throw new IllegalArgumentException("zle dane");
        this.a = a;
        this.b = b;    
    }

    @Override
    double calculateArea() {
        return a*b;
    }

    @Override
    double calculatePerimeter() {
        return 2*a+2*b;
    }

    @Override
    public void print() {
        System.out.printf("Prostokat, pole: " + calculateArea() + ", obwod: " + calculatePerimeter() + "\n");
    }
    
}
