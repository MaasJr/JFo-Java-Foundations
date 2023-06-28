import java.util.Scanner;

public class JFo_05_03_exercicio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o código da cor: ");
        int currentColor = scanner.nextInt();

        String nextColor;

        switch (currentColor) {
            case 1:
                nextColor = "verde";
                break;
            case 2:
                nextColor = "amarelo";
                break;
            case 3:
                nextColor = "vermelho";
                break;
            default:
                nextColor = "inválida";
                break;
        }

        if (!nextColor.equals("inválida")) {
            System.out.println("Próximo semáforo será " + nextColor);
        } else {
            System.out.println("Cor inválida");
        }

        scanner.close();
    }
}
