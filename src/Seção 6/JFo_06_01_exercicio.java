import java.util.Scanner;

public class JFo_06_01_exercicio {
    public static void main(String[] args) {
        final int validPin = 1234;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema bancário!");

        int enteredPin = -1;

        while (enteredPin != validPin) {
            System.out.print("Digite seu PIN: ");
            enteredPin = scanner.nextInt();

            if (enteredPin != validPin) {
                System.out.println("PIN incorreto. Tente novamente.");
            }
        }

        System.out.println("PIN correto inserido. Você agora tem acesso à conta.");

        scanner.close();
    }
}

