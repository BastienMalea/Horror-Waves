package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import launcher.Launch;

import java.io.IOException;

public class VueGameOver {
    public void retourMenu(ActionEvent actionEvent) throws IOException {
        Parent racine = FXMLLoader.load(Launch.class.getResource("/FXML/Menu.fxml"));
        Scene scene = new Scene(racine);
        scene.getStylesheets().addAll(this.getClass().getResource("/FXML/style.css").toExternalForm());
        Launch.getPrimaryStage().setScene(scene);
    }
}
