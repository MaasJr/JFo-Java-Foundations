import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JFo_09_01_exercicio {

    private static final int MAP_WIDTH = 800; // Largura do mapa
    private static final int MAP_HEIGHT = 600; // Altura do mapa

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, MAP_WIDTH, MAP_HEIGHT);
        primaryStage.setTitle("Campus Map");
        primaryStage.setScene(scene);

        Dormitorio dormitorio1 = new Dormitorio("Dormitório 1", 100, 200, 20);
        Dormitorio dormitorio2 = new Dormitorio("Dormitório 2", 300, 400, 15);

        root.getChildren().addAll(
                dormitorio1.getShape(),
                dormitorio1.getLabel(),
                dormitorio2.getShape(),
                dormitorio2.getLabel()
        );

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static class Dormitorio {
        private String nome;
        private int posX;
        private int posY;
        private int populacao;
        private Circle shape;
        private Text label;

        public Dormitorio(String nome, int posX, int posY, int populacao) {
            this.nome = nome;
            this.posX = posX;
            this.posY = posY;
            this.populacao = populacao;

            shape = new Circle(10);
            shape.setFill(Color.BLUE);
            shape.setCenterX(posX);
            shape.setCenterY(posY);

            label = new Text(nome + " (População: " + populacao + ")");
            label.setFill(Color.WHITE);
            label.setX(posX - 30);
            label.setY(posY + 25);
        }

        public Circle getShape() {
            return shape;
        }

        public Text getLabel() {
            return label;
        }
    }
}
