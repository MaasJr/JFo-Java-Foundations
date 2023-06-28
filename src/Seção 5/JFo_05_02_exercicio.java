import java.util.Scanner;

public class JFo_05_02_exercicio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o código da cor: ");
        int currentColor = scanner.nextInt();

        if (currentColor == 1) {
            System.out.println("Próximo semáforo será verde");
        } else if (currentColor == 2) {
            System.out.println("Próximo semáforo será amarelo");
        } else if (currentColor == 3) {
            System.out.println("Próximo semáforo será vermelho");
        } else {
            System.out.println("Cor inválida");
        }

        scanner.close();
    }
}
