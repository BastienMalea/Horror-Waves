package launcher;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

public class Launch extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent racine= FXMLLoader.load(getClass().getResource("/FXML/test.fxml"));
        Scene scene=new Scene(racine);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
