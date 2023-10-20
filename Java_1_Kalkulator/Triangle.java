import java.util.Scanner;

public class Triangle extends Figure {
    double a, b, c;

    public Triangle() {

        Scanner scanner = new Scanner(System.in);
        boolean dobreDane = true;
        while (dobreDane) {
            System.out.println("Podaj bok a");
            this.a = scanner.nextDouble();

            System.out.println("Podaj bok b");
            this.b = scanner.nextDouble();

            System.out.println("Podaj bok c");
            this.c = scanner.nextDouble();
            if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
                System.out.println("zle dane");

            } else 
                dobreDane = false;
        }

        scanner.close();

    }

    @Override
    double calculateArea() {

    }

    @Override
    double calculatePerimeter() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculatePerimeter'");
    }

}
