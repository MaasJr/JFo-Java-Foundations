import java.util.Scanner;

public class JFo_06_02_exercicio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Escolha um número: ");
        int number = scanner.nextInt();

        for (int i = 1; i <= 12; i++) {
            int multiple = number * i;
            System.out.println(number + "x" + i + " = " + multiple);
        }

        scanner.close();
    }
}
