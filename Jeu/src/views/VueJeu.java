package views;

import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;
import launcher.Launch;
import modele.management.Manager;

public class VueJeu {

    @FXML
    private Rectangle rectangle;

    Manager manager = Launch.getManager();

    public void initialize(){
        rectangle.xProperty().bind(manager.getJoueur().posXProperty());
    }
}
