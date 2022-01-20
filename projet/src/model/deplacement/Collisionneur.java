package model.deplacement;

import javafx.beans.property.SimpleDoubleProperty;
import model.entite.Personnage;

/**
 * Classe abstraite qui va verifier les collisions
 */
public abstract class Collisionneur {

    private SimpleDoubleProperty hauteurFenetre = new SimpleDoubleProperty();
    public double gethauteurFenetre() { return hauteurFenetre.get(); }
    public void sethauteurFenetre(double hauteurFenetre) { this.hauteurFenetre.set(hauteurFenetre); }
    public SimpleDoubleProperty hauteurFenetreProperty() { return hauteurFenetre; }

    private SimpleDoubleProperty largeurFenetre = new SimpleDoubleProperty();
    public double getlargeurFenetre() { return largeurFenetre.get(); }
    public void setlargeurFenetre(double largeurFenetre) { this.largeurFenetre.set(largeurFenetre); }
    public SimpleDoubleProperty largeurFenetreProperty() { return largeurFenetre; }

    /**
     * Methode qui va verifier la collision entre un personnage p et la fenêtre du Milieu
     * @param x Coordonnée x du personnage
     * @param y Coordonée y du personnage
     * @param p Personnage
     * @return Boolean
     */
    public abstract Boolean isCollision(double x, double y, Personnage p);

    /**
     * Méthode qui va verifier la collision entre un Monstre et la fenêtre Principale
     * @param x Coordonnée x du personnage
     * @param y Coordonée y du personnage
     * @param p Personnage (monstre dans ce cas)
     * @return Boolean
     */
    public abstract Boolean isCollisionMonstreWindow(double x, double y, Personnage p);

    /**
     * Méthode qui va verifier les collisions entre 2 Personnage
     * @param p Premier Personnage
     * @param p Deuxieme Personnage
     * @return Boolean
     */
    public abstract Boolean isCollisionEntity(Personnage p, Personnage p2);
}
