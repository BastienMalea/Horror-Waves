package modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public abstract class Entite {
    private DoubleProperty x = new SimpleDoubleProperty();
    public double getX(){ return x.get();}
    public DoublePreperty xProperty()


        //Rajouter des proprietes hauteur et largeur

    public Entite(double hauteur, double largeur)
    {
        setHauteur(hauteur);
        setLargeur(largeur);
    }
}
