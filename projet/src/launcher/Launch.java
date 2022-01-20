package launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

/**
 * Launcher de notre jeu
 */
public class Launch extends Application {
    private static Stage primaryStage;
    private static Stage stage;

    /**
     * Methode qui lance le jeu en chargant un stage avec une scene
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        Parent racine = FXMLLoader.load(Launch.class.getResource("/FXML/Menu.fxml"));
        Scene scene = new Scene(racine);

        scene.getStylesheets().addAll(this.getClass().getResource("/FXML/style.css").toExternalForm());

        primaryStage.setResizable(false);
        primaryStage.setHeight(800);
        primaryStage.getIcons().add(new Image("/Image/Icon.png"));
        primaryStage.setWidth(1200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Methode qui retourne le stage Principal
     * @return
     */
    public static Stage getPrimaryStage(){
        return primaryStage;
    }

}
