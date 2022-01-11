package views;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import launcher.Launch;
import modele.management.Manager;
import modele.personnage.Personnage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VueJeu{

    @FXML
    private Rectangle rectangle;


    Manager manager = Launch.getManager();
    Personnage joueur = manager.getJoueur();


    @FXML
    public void initialize(){
        rectangle.xProperty().bindBidirectional(joueur.posXProperty());
        rectangle.yProperty().bindBidirectional(joueur.posYProperty());
    }

}
