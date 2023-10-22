import java.util.Scanner;

public class Kalkulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        int x;
        
        boolean koniec = true;
        while (koniec) {
            System.out.print("1 - trojkat\t");
            System.out.print("2 - prostkat\t");
            System.out.print("3 - romb\t");
            System.out.print("4 - graniastoslup\t");
            System.out.println("5 - wyjscie");
            
            //double x = scanner.nextDouble();
            x = Integer.parseInt(scanner.nextLine());
            System.out.println("---------------------------");
            switch (x) {
                case 1:
                    triangle();
                    break;
                case 2:
                    rectangle();
                    break;
                case 3:
                    diamond();
                    break;
                case 4:

                    break;
                case 5:
                    System.exit(0);
                    break;

                default:
                    System.out.println("nieprawidlowy wybor");
                    break;
                }
              
        }
         scanner.close();      

        
    }

    static void triangle() {
        Scanner scanner = new Scanner(System.in);
       

        System.out.println("Podaj bok a");
        double a =  Double.parseDouble(scanner.nextLine());
        System.out.println("Podaj bok b");
        double b =  Double.parseDouble(scanner.nextLine());
        System.out.println("Podaj bok c");
        double c =  Double.parseDouble(scanner.nextLine());
        try {
            Triangle triangle = new Triangle(a, b, c);
            triangle.print();
        } catch (IllegalArgumentException e) {
            System.out.println("Niepoprawne dlugosci bokow trojkata.");
        }
        
        scanner.close();
    }

    static void rectangle() {
        Scanner scannerR = new Scanner(System.in);

        System.out.println("Podaj bok a");
        double a = scannerR.nextDouble();
        System.out.println("Podaj bok b");
        double b = scannerR.nextDouble();
        try {
            Rectangle rectangle = new Rectangle(a, b);
            rectangle.print();
        } catch (IllegalArgumentException e) {
            System.out.println("Niepoprawne dlugosci bokow prostokata.");
        }

        scannerR.close();
    }

    static void diamond() {
        Scanner scannerD = new Scanner(System.in);

        System.out.println("Podaj pierwsza przekatna");
        double a = scannerD.nextDouble();
        System.out.println("Podaj druga przekatna");
        double b = scannerD.nextDouble();

        try {
            Diamond diamond = new Diamond(a, b);
            diamond.print();
        } catch (IllegalArgumentException e) {
            System.out.println("Niepoprawne dlugosci lub kat rombu.");
        }

        scannerD.close();
    }

    static void threeDim() {
        Scanner scannerTD = new Scanner(System.in);
        Scanner scannerH = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        
        int x;
        double wysokosc;
        Figure fig;
        System.out.println("Podaj wysokosc figury");
        wysokosc = scannerH.nextDouble();

        System.out.println("Podaj figure podstawy 1 - trojkat, 2 - prostokat, 3 - romb");
        x = Integer.parseInt(scanner.nextLine());


        if (x < 1 || x > 3) {
            System.out.println("Niepoprawny wybor figury");
        } else {
            switch (x) {
                case 1:
                    System.out.println("Podaj bok a");
                    double a = scannerH.nextDouble();
                    System.out.println("Podaj bok b");
                    double b = scannerH.nextDouble();
                    System.out.println("Podaj bok c");
                    double c = scannerH.nextDouble();
                    try {
                        fig = new Triangle(a, b, c);
                        ThreeDim threeDim = new ThreeDim(fig, wysokosc);
                        threeDim.print();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Niepoprawna wysokosc");
                    }
                break;
                case 2:
                    System.out.println("Podaj bok a");
                    double e = scannerH.nextDouble();
                    System.out.println("Podaj bok b");
                    double f = scannerH.nextDouble();
                    try {
                        fig = new Rectangle(e, f);
                        ThreeDim threeDim = new ThreeDim(fig, wysokosc);
                        threeDim.print();
                    } catch (IllegalArgumentException k) {
                        System.out.println("Niepoprawna wyskosc");
                    }
                break;
                case 3:
                    System.out.println("Podaj pierwsza przekatna");
                    double g = scannerH.nextDouble();
                    System.out.println("Podaj druga przekatna");
                    double h = scannerH.nextDouble();

                    try {
                        fig = new Diamond(g, h);
                        ThreeDim threeDim = new ThreeDim(fig, wysokosc);
                        threeDim.print();
                    } catch (IllegalArgumentException l) {
                        System.out.println("Niepoprawne dlugosci lub kat rombu.");
                    }

                default:
                System.out.println("blad");
                break;

            }

            scannerTD.close();
            scannerH.close();
            scanner.close();
        }

    }
}
