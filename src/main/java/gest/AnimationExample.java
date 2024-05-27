package gest;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
        import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimationExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Rectangle rectangle = new Rectangle(50, 50, Color.MEDIUMAQUAMARINE);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(9), rectangle);
        translateTransition.setByX(1000);

        translateTransition.play();

        StackPane root = new StackPane(rectangle);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Animation Example");
        primaryStage.show();
    }
}
    

