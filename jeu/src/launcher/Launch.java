package launcher;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import modele.management.Manager;

import java.io.IOException;


public class Launch extends Application {
    static Manager manager = new Manager();

    static Parent racine;

    static {
        try {
            racine = FXMLLoader.load(Launch.class.getResource("/FXML/vueJeu.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Scene scene = new Scene(racine);

    @Override
    public void start(Stage primaryStage) throws Exception {
        Manager manager = new Manager();
        manager.jeu(scene);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static Manager getManager(){ return manager; }
    public static Scene getScene(){ return scene; }


}
