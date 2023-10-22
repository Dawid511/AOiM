import java.util.Scanner;

public class Kalkulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        int x;
        double a, b, c;
        
        boolean koniec = true;
        while (koniec) {
            System.out.print("1 - trojkat\t");
            System.out.print("2 - prostkat\t");
            System.out.print("3 - romb\t");
            System.out.print("4 - graniastoslup\t");
            System.out.println("5 - wyjscie");

            x = Integer.parseInt(scanner.nextLine());
            switch (x) {
                case 1:
                    System.out.println("Podaj bok a");
                    a =  Double.parseDouble(scanner.nextLine());
                    System.out.println("Podaj bok b");
                    b =  Double.parseDouble(scanner.nextLine());
                    System.out.println("Podaj bok c");
                    c =  Double.parseDouble(scanner.nextLine());
                    try {
                        Triangle triangle = new Triangle(a, b, c);
                        triangle.print();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Niepoprawne dlugosci bokow trojkata.");
                    }
                    break;
                case 2:
                    System.out.println("Podaj bok a");
                    a = Double.parseDouble(scanner.nextLine());
                    System.out.println("Podaj bok b");
                    b = Double.parseDouble(scanner.nextLine());
                    try {
                        Rectangle rectangle = new Rectangle(a, b);
                        rectangle.print();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Niepoprawne dlugosci bokow prostokata.");
                    }
                    break;
                case 3:
                    System.out.println("Podaj pierwsza przekatna");
                    a = Double.parseDouble(scanner.nextLine());
                    System.out.println("Podaj druga przekatna");
                    b = Double.parseDouble(scanner.nextLine());

                    try {
                        Diamond diamond = new Diamond(a, b);
                        diamond.print();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Niepoprawne dlugosci przekatnych");
                    }

                    break;
                case 4:
                    double wysokosc;
                    Figure fig;
                    System.out.println("Podaj wysokosc figury");
                    wysokosc = Double.parseDouble(scanner.nextLine());

                    System.out.println("Podaj figure podstawy 1 - trojkat, 2 - prostokat, 3 - romb");
                    x = Integer.parseInt(scanner.nextLine());


                    if (x < 1 || x > 3) {
                        System.out.println("Niepoprawny wybor figury");
                    } else {
                        switch (x) {
                            case 1:
                                System.out.println("Podaj bok a");
                                a = Double.parseDouble(scanner.nextLine());
                                System.out.println("Podaj bok b");
                                b = Double.parseDouble(scanner.nextLine());
                                System.out.println("Podaj bok c");
                                c = Double.parseDouble(scanner.nextLine());
                                try {
                                    fig = new Triangle(a, b, c);
                                    ThreeDim threeDim = new ThreeDim(fig, wysokosc);
                                    threeDim.print();
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Niepoprawne dane");
                                }
                            break;
                            case 2:
                                System.out.println("Podaj bok a");
                                a = Double.parseDouble(scanner.nextLine());
                                System.out.println("Podaj bok b");
                                b = Double.parseDouble(scanner.nextLine());
                                try {
                                    fig = new Rectangle(a, b);
                                    ThreeDim threeDim = new ThreeDim(fig, wysokosc);
                                    threeDim.print();
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Niepoprawne dane");
                                }
                            break;
                            case 3:
                                System.out.println("Podaj pierwsza przekatna");
                                a = Double.parseDouble(scanner.nextLine());
                                System.out.println("Podaj druga przekatna");
                                b = Double.parseDouble(scanner.nextLine());

                                try {
                                    fig = new Diamond(a, b);
                                    ThreeDim threeDim = new ThreeDim(fig, wysokosc);
                                    threeDim.print();
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Niepoprawne dane");
                                }

                            default:
                            System.out.println("blad");
                            break;

                            }

         
                         }

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
}
