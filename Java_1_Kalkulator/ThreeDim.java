public class ThreeDim{
    Figure figure;
    double height;

    ThreeDim(Figure figure, double h) {
        if (h <= 0)
            throw new IllegalArgumentException("zle dane");
    }

    double calculateArea() {
        return figure.calculateArea()*2 + figure.calculatePerimeter()*height;
    }

    double calculateVolume() {
        return figure.calculateArea()*height;
    }

    public void print() {
        System.out.printf("Graniastoslup, pole powierzchni: " + calculateArea() + ", objetosc: " + calculateVolume() + "\n");
    }

}
