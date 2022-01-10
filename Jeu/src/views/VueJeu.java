package views;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;
import launcher.Launch;
import modele.management.Manager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VueJeu{

    @FXML
    private Rectangle rectangle;


    Manager manager = Launch.getManager();
    

    @FXML
    public void initialize(){
        rectangle.xProperty().bindBidirectional(manager.getJoueur().posXProperty());
        rectangle.yProperty().bindBidirectional(manager.getJoueur().posYProperty());
    }

}
