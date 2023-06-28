public class TestClass {
    public static void main(String[] args) {
        ComputeMethods computeMethods = new ComputeMethods();

        double tempInFahrenheit = 100.0;
        double tempInCelsius = computeMethods.fToC(tempInFahrenheit);
        System.out.println("Temp in celsius is " + tempInCelsius);

        int sideA = 8;
        int sideB = 6;
        double hypotenuse = computeMethods.hypotenuse(sideA, sideB);
        System.out.println("Hypotenuse is " + hypotenuse);

        int sumOfDice = computeMethods.roll();
        System.out.println("The sum of the dice values is " + sumOfDice);
    }
}
