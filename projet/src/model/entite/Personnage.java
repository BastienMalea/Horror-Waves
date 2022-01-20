package model.entite;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Classe abstraite Personnage
 */
public abstract class Personnage {

    //Propriété qui est la coordonée en X
    private SimpleDoubleProperty posX = new SimpleDoubleProperty();
        public double getPosX() { return posX.get(); }
        public void setPosX(double posX) { this.posX.set(posX); this.setPosCentreX(posX+(this.getHitBoxLargeur())/2); }
        public SimpleDoubleProperty posXProperty() { return posX; }

    //Propriété qui est la coordonée en Y
    private SimpleDoubleProperty posY = new SimpleDoubleProperty();
        public double getPosY() { return posY.get(); }
        public void setPosY(double posY) { this.posY.set(posY); this.setPosCentreY(posY+(this.getHitBoxHauteur())/2); }
        public SimpleDoubleProperty posYProperty() { return posY; }

    //Propriété qui est la hauteur du Personnage
    private SimpleDoubleProperty hauteur = new SimpleDoubleProperty();
        public double getHauteur() { return hauteur.get(); }
        public void setHauteur(double hauteur) { this.hauteur.set(hauteur); }
        public SimpleDoubleProperty hauteurProperty() { return hauteur; }

    //Propriété qui est la largeur du Personnage
    private SimpleDoubleProperty largeur = new SimpleDoubleProperty();
        public double getLargeur() { return largeur.get(); }
        public void setLargeur(double largeur) { this.largeur.set(largeur); }
        public SimpleDoubleProperty largeurProperty() { return largeur; }

    //Propriété qui est la hauteur de la hitbox du Personnage
    private SimpleDoubleProperty hitBoxHauteur = new SimpleDoubleProperty();
        public double getHitBoxHauteur() { return hitBoxHauteur.get(); }
        public void setHitBoxHauteur(double hitBoxHauteur) { this.hitBoxHauteur.set(hitBoxHauteur); }
        public SimpleDoubleProperty hitBoxHauteurProperty() { return hitBoxHauteur; }

    //Propriété qui est la largeur de la hitbox du Personnage
    private SimpleDoubleProperty hitBoxLargeur = new SimpleDoubleProperty();
        public double getHitBoxLargeur() { return hitBoxLargeur.get(); }
        public void setHitBoxLargeur(double hitBoxLargeur) { this.hitBoxLargeur.set(hitBoxLargeur); }
        public SimpleDoubleProperty hitBoxLargeurProperty() { return hitBoxLargeur; }

    //Propriété qui est le centre X de la hitbox du Personnage
    private SimpleDoubleProperty posCentreX = new SimpleDoubleProperty();
        public double getPosCentreX() { return posCentreX.get(); }
        public void setPosCentreX(double posCentreX) { this.posCentreX.set(posCentreX); }
        public SimpleDoubleProperty posCentreXProperty() { return posCentreX; }

    //Propriété qui est le centre Y de la hitbox du Personnage
    private SimpleDoubleProperty posCentreY = new SimpleDoubleProperty();
        public double getPosCentreY() { return posCentreY.get(); }
        public void setPosCentreY(double posCentreY) { this.posCentreY.set(posCentreY); }
        public SimpleDoubleProperty posCentreYProperty() { return posCentreY; }

    //Propriété des points de vies du personnage
    private SimpleIntegerProperty pv = new SimpleIntegerProperty();
        public int getPv() { return pv.get(); }
        public void setPv(int pv) { this.pv.set(pv);}
        public SimpleIntegerProperty pvProperty() { return pv; }

    /**
     * Constructeur du Personnage
     * @param x coordonée x
     * @param y coordonée y
     * @param hauteur hauteur du personnage
     * @param largeur largeur du personnage
     * @param ratioHitBoxX ratio de la hitbox en X du personnage
     * @param ratioHitBoxY ratio de la hitbox en Y du personnage
     * @param pv Points de vie du personnage
     */
    public Personnage(double x, double y, double hauteur, double largeur, double ratioHitBoxX, double ratioHitBoxY, int pv){
        setHauteur(hauteur);
        setLargeur(largeur);
        setHitBoxHauteur(hauteur*ratioHitBoxY);
        setHitBoxLargeur(largeur*ratioHitBoxX);
        setPosX(x);
        setPosY(y);
        setPv(pv);
    }
}
