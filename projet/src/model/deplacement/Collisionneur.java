package model.deplacement;

import javafx.beans.property.SimpleDoubleProperty;
import model.entite.Personnage;

public abstract class Collisionneur {

    private SimpleDoubleProperty hauteurFenetre = new SimpleDoubleProperty();
    public double gethauteurFenetre() { return hauteurFenetre.get(); }
    public void sethauteurFenetre(double hauteurFenetre) { this.hauteurFenetre.set(hauteurFenetre); }
    public SimpleDoubleProperty hauteurFenetreProperty() { return hauteurFenetre; }

    private SimpleDoubleProperty largeurFenetre = new SimpleDoubleProperty();
    public double getlargeurFenetre() { return largeurFenetre.get(); }
    public void setlargeurFenetre(double largeurFenetre) { this.largeurFenetre.set(largeurFenetre); }
    public SimpleDoubleProperty largeurFenetreProperty() { return largeurFenetre; }

    public abstract Boolean isCollision(double x, double y, Personnage p);
    public abstract Boolean isCollisionEntity(Personnage p, Personnage p2);
}
