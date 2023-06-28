import javax.swing.JOptionPane;

public class JFo_03_exercicio {

    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Digite o seu nome:");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Digite a sua idade:"));
        double height = Double.parseDouble(JOptionPane.showInputDialog("Digite a sua altura em metros:"));
        String animal = JOptionPane.showInputDialog("Digite um nome de animal:");
        String place = JOptionPane.showInputDialog("Digite um nome de lugar:");
        int number = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro:"));
        double temperature = Double.parseDouble(JOptionPane.showInputDialog("Digite uma temperatura em graus Celsius:"));
        String color = JOptionPane.showInputDialog("Digite uma cor:");
        String food = JOptionPane.showInputDialog("Digite um alimento:");
        int distance = Integer.parseInt(JOptionPane.showInputDialog("Digite uma distância em metros:"));
        double weight = Double.parseDouble(JOptionPane.showInputDialog("Digite o seu peso em kg:"));
        int doubleNumber = number * 2;
        double bmi = weight / (height * height);

        String story = "Olá, " + name + "! Você tem " + age + " anos e mede " + height + " metros de altura.\n\n";
        story += "Uma vez, em um lugar chamado " + place + ", um " + animal + " apareceu.\n";
        story += "Ele era " + color + " e estava procurando por " + food + ".\n";
        story += "A temperatura naquele dia era de " + temperature + " graus Celsius.\n\n";
        story += "Curiosamente, o " + animal + " estava carregando " + doubleNumber + " " + animal + "s consigo.\n";
        story += "Eles percorreram uma distância de " + distance + " metros até chegarem a uma floresta.\n";
        story += "Lá, encontraram um rio e decidiram nadar.\n\n";
        story += "Depois de um dia cheio de aventuras, o " + animal + " voltou para casa.\n";
        story += "No caminho de volta, encontrou um amigo e juntos foram jantar.\n";
        story += "Você, " + name + ", tem um índice de massa corporal (IMC) de " + bmi + ".\n";
        story += "Espero que tenha gostado dessa história divertida!";

        JOptionPane.showMessageDialog(null, story);
    }
}
