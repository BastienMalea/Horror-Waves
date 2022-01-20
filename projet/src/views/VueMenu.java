package views;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import launcher.Launch;

import java.io.IOException;

public class VueMenu {

    @FXML
    public void initialize(){

    }

    //Quand l'utilisateur clique sur le bouton "JOUER"
    public void lancerPartie(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent racine = FXMLLoader.load(Launch.class.getResource("/FXML/vueJeu.fxml"));
        Scene scene = new Scene(racine);
        scene.getStylesheets().addAll(this.getClass().getResource("/FXML/style.css").toExternalForm());
        Launch.getPrimaryStage().setScene(scene);
    }
}
