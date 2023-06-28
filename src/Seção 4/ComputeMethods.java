public class ComputeMethods {
    public double fToC(double degreesF) {
        double degreesC = (5.0 / 9.0) * (degreesF - 32);
        return degreesC;
    }

    public double hypotenuse(int a, int b) {
        double hypotenuse = Math.sqrt(a * a + b * b);
        return hypotenuse;
    }

    public int roll() {
        int dice1 = (int) (Math.random() * 6) + 1;
        int dice2 = (int) (Math.random() * 6) + 1;
        int sum = dice1 + dice2;
        return sum;
    }
}
