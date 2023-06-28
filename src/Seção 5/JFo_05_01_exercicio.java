import java.util.Scanner;

 public class JFo_05_01_exercicio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um código de cor: ");
        double wavelength = scanner.nextDouble();

        if (wavelength >= 380 && wavelength < 450) {
            System.out.println("A cor é violeta");
        } else if (wavelength >= 450 && wavelength < 495) {
            System.out.println("A cor é azul");
        } else if (wavelength >= 495 && wavelength < 570) {
            System.out.println("A cor é verde");
        } else if (wavelength >= 570 && wavelength < 590) {
            System.out.println("A cor é amarela");
        } else if (wavelength >= 590 && wavelength < 620) {
            System.out.println("A cor é laranja");
        } else if (wavelength >= 620 && wavelength <= 750) {
            System.out.println("A cor é vermelha");
        } else {
            System.out.println("A faixa de comprimento de onda fornecida não faz parte do espectro visível.");
        }

        scanner.close();
    }
}
