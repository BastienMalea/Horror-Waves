package launch;

import view.FenetreSimple;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.management.StandardEmitterMBean;

public class Launch extends Application {

    private static Stage primaryStage;


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage=primaryStage;
        Scene scene = new Scene(new FenetreSimple());
        primaryStage.setScene(scene);
        primaryStage.setHeight(400);
        primaryStage.setWidth(400);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getPrimaryStage(){
        return primaryStage;
    }
}
