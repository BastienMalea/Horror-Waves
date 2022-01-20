package model.manager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Classe qui permet de naviguer entre les différentes vues
 */
public class Navigateur {

    //Dictionnaire qui permet de passer des string pour la methode NavigateTo
    private final Map<String, Scene> mapScene = new HashMap<>();

    public Navigateur() throws IOException {
        mapScene.put("VueJeu", new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/vueJeu.fxml")))));
        mapScene.put("Menu", new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/Menu.fxml")))));
    }

    public void navigateTo(String scene, Stage stage){
        Scene sceneCourante= mapScene.get(scene);
        stage.setScene(sceneCourante);
        stage.show();
    }
}
