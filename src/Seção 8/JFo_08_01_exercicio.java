import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Equipe {
    private String nome;
    private int vitorias;
    private int derrotas;
    private int empates;
    private int golsMarcados;
    private int golsSofridos;

    public Equipe(String nome) {
        this.nome = nome;
        this.vitorias = 0;
        this.derrotas = 0;
        this.empates = 0;
        this.golsMarcados = 0;
        this.golsSofridos = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getVitorias() {
        return vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public int getGolsMarcados() {
        return golsMarcados;
    }

    public int getGolsSofridos() {
        return golsSofridos;
    }

    public void incrementarVitorias() {
        vitorias++;
    }

    public void incrementarDerrotas() {
        derrotas++;
    }

    public void incrementarEmpates() {
        empates++;
    }

    public void incrementarGolsMarcados(int gols) {
        golsMarcados += gols;
    }

    public void incrementarGolsSofridos(int gols) {
        golsSofridos += gols;
    }

    public int getSaldoGols() {
        return golsMarcados - golsSofridos;
    }

    @Override
    public String toString() {
        return nome + "\n" +
                "Vitórias: " + vitorias + ", Derrotas: " + derrotas + ", Empates: " + empates + "\n" +
                "Gols Marcados: " + golsMarcados + ", Gols Sofridos: " + golsSofridos + "\n";
    }
}

class Jogo {
    private int numeroJogo;
    private int temperatura;
    private Equipe equipeCasa;
    private Equipe equipeVisitante;
    private int golsCasa;
    private int golsVisitante;

    public Jogo(int numeroJogo, int temperatura, Equipe equipeCasa, Equipe equipeVisitante) {
        this.numeroJogo = numeroJogo;
        this.temperatura = temperatura;
        this.equipeCasa = equipeCasa;
        this.equipeVisitante = equipeVisitante;
        this.golsCasa = 0;
        this.golsVisitante = 0;
    }

    public int getNumeroJogo() {
        return numeroJogo;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public Equipe getEquipeCasa() {
        return equipeCasa;
    }

    public Equipe getEquipeVisitante() {
        return equipeVisitante;
    }

    public int getGolsCasa() {
        return golsCasa;
    }

    public int getGolsVisitante() {
        return golsVisitante;
    }

    public void jogarJogo() {
        Random random = new Random();
        golsCasa = random.nextInt(5);
        golsVisitante = random.nextInt(5);
        equipeCasa.incrementarGolsMarcados(golsCasa);
        equipeCasa.incrementarGolsSofridos(golsVisitante);
        equipeVisitante.incrementarGolsMarcados(golsVisitante);
        equipeVisitante.incrementarGolsSofridos(golsCasa);

        if (golsCasa > golsVisitante) {
            equipeCasa.incrementarVitorias();
            equipeVisitante.incrementarDerrotas();
        } else if (golsCasa < golsVisitante) {
            equipeCasa.incrementarDerrotas();
            equipeVisitante.incrementarVitorias();
        } else {
            equipeCasa.incrementarEmpates();
            equipeVisitante.incrementarEmpates();
        }
    }

    @Override
    public String toString() {
        return "Jogo #" + numeroJogo + "\n" +
                "Temperatura: " + temperatura + "\n" +
                "Equipe Visitante: " + equipeVisitante.getNome() + ", " + golsVisitante + "\n" +
                "Equipe Casa: " + equipeCasa.getNome() + ", " + golsCasa + "\n";
    }
}

public class JFo_08_01_exercicio {
    private List<Jogo> jogos;
    private List<Equipe> equipes;
    private int semanasFriasConsecutivas;
    private int temperaturaMaisAlta;
    private int temperaturaTotal;
    private int quantidadeJogos;

    public JFo_08_01_exercicio() {
        jogos = new ArrayList<>();
        equipes = new ArrayList<>();
        semanasFriasConsecutivas = 0;
        temperaturaMaisAlta = 0;
        temperaturaTotal = 0;
        quantidadeJogos = 0;
    }

    public void adicionarEquipe(Equipe equipe) {
        equipes.add(equipe);
    }

    public void simularTemporada() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        while (semanasFriasConsecutivas < 3) {
            System.out.print("Digite a temperatura (em Fahrenheit): ");
            int temperatura = scanner.nextInt();

            if (temperatura < 32) {
                semanasFriasConsecutivas++;
                System.out.println("Frio demais para jogar.");
                continue;
            } else {
                semanasFriasConsecutivas = 0;
            }

            if (temperatura > temperaturaMaisAlta) {
                temperaturaMaisAlta = temperatura;
            }
            temperaturaTotal += temperatura;
            quantidadeJogos += 2;

            Equipe equipe1 = obterEquipeAleatoria();
            Equipe equipe2 = obterEquipeAleatoria(equipe1);

            Jogo jogo1 = new Jogo(quantidadeJogos - 1, temperatura, equipe1, equipe2);
            Jogo jogo2 = new Jogo(quantidadeJogos, temperatura, equipe2, equipe1);

            jogos.add(jogo1);
            jogos.add(jogo2);

            jogo1.jogarJogo();
            jogo2.jogarJogo();
        }

        System.out.println("Temporada encerrada\n");
        imprimirEstatisticasEquipes();
        imprimirEstatisticasJogos();
    }

    private Equipe obterEquipeAleatoria() {
        Random random = new Random();
        return equipes.get(random.nextInt(equipes.size()));
    }

    private Equipe obterEquipeAleatoria(Equipe equipeExcluida) {
        Random random = new Random();
        Equipe equipeAleatoria = equipeExcluida;
        while (equipeAleatoria == equipeExcluida) {
            equipeAleatoria = equipes.get(random.nextInt(equipes.size()));
        }
        return equipeAleatoria;
    }

    private void imprimirEstatisticasEquipes() {
        for (Equipe equipe : equipes) {
            System.out.println(equipe);
        }
    }

    private void imprimirEstatisticasJogos() {
        System.out.println("Jogos:");
        for (Jogo jogo : jogos) {
            System.out.println(jogo);
        }

        double mediaTemperatura = (double) temperaturaTotal / quantidadeJogos;
        System.out.println("Temperatura mais alta: " + temperaturaMaisAlta);
        System.out.println("Temperatura média: " + mediaTemperatura);
    }

    public static void main(String[] args) {
        JFo_08_01_exercicio simulador = new JFo_08_01_exercicio();

        Equipe equipe1 = new Equipe("Time 1");
        Equipe equipe2 = new Equipe("Time 2");
        Equipe equipe3 = new Equipe("Time 3");
        Equipe equipe4 = new Equipe("Time 4");

        simulador.adicionarEquipe(equipe1);
        simulador.adicionarEquipe(equipe2);
        simulador.adicionarEquipe(equipe3);
        simulador.adicionarEquipe(equipe4);

        simulador.simularTemporada();
    }
}
