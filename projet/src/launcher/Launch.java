package launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launch extends Application {
    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        Parent racine = FXMLLoader.load(Launch.class.getResource("/FXML/vueJeu.fxml"));
        Scene scene = new Scene(racine);

        scene.getStylesheets().addAll(this.getClass().getResource("/FXML/style.css").toExternalForm());

        primaryStage.setResizable(false);
        primaryStage.setHeight(800);
        primaryStage.setWidth(1200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static Stage getPrimaryStage(){
        return primaryStage;
    }

}
