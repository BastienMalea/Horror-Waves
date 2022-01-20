package model.deplacement;

import javafx.scene.input.KeyCode;
import model.boucle.Observeur;

/**
 * Classe qui va déplacer les Personnages
 */
public abstract class Deplaceur extends Observeur {

    protected Collisionneur collisionneur;

    public Deplaceur(Collisionneur collisionneur){
        this.collisionneur = collisionneur;
    }


}
