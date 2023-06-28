import java.util.Scanner;

public class ManipuladorDeNome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type your name: ");
        String fullName = scanner.nextLine();

        int spaceIndex = fullName.indexOf(" ");
        String firstName = fullName.substring(0, spaceIndex);
        String lastName = fullName.substring(spaceIndex + 1);

        String formattedName = lastName + ", " + firstName.charAt(0) + ".";

        System.out.println("Your name is: " + formattedName);

        scanner.close();
    }
}