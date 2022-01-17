package model.deplacement;

import javafx.scene.input.KeyCode;
import model.boucle.Observeur;

public abstract class Deplaceur extends Observeur {

    protected Collisionneur collisionneur;

    public Deplaceur(Collisionneur collisionneur){
        this.collisionneur = collisionneur;
    }

    public abstract void ajouterTouche(KeyCode code);
    public abstract void supprimerTouche(KeyCode code);

}
