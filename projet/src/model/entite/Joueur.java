package model.entite;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * Classe de notre joueur qui implémente les propriétés du Personnage
 */

public class Joueur extends Personnage{

    public Joueur(double x, double y, double hauteur, double largeur, double ratioHitBoxX, double ratioHitBoxY, int pv){
        super(x, y, hauteur, largeur, ratioHitBoxX, ratioHitBoxY, pv);
    }

}
