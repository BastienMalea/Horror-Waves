package model.entite;

import javafx.beans.property.SimpleDoubleProperty;

public abstract class Personnage {

    private SimpleDoubleProperty posX = new SimpleDoubleProperty();
        public double getPosX() { return posX.get(); }
        public void setPosX(double posX) { this.posX.set(posX); this.setPosCentreX(posX+(this.getLargeur())/2); }
        public SimpleDoubleProperty posXProperty() { return posX; }

    private SimpleDoubleProperty posY = new SimpleDoubleProperty();
        public double getPosY() { return posY.get(); }
        public void setPosY(double posY) { this.posY.set(posY); this.setPosCentreY(posY+(this.getHauteur())/2); }
        public SimpleDoubleProperty posYProperty() { return posY; }

    private SimpleDoubleProperty hauteur = new SimpleDoubleProperty();
        public double getHauteur() { return hauteur.get(); }
        public void setHauteur(double hauteur) { this.hauteur.set(hauteur); }
        public SimpleDoubleProperty hauteurProperty() { return hauteur; }

    private SimpleDoubleProperty largeur = new SimpleDoubleProperty();
        public double getLargeur() { return largeur.get(); }
        public void setLargeur(double largeur) { this.largeur.set(largeur); }
        public SimpleDoubleProperty largeurProperty() { return largeur; }


    private SimpleDoubleProperty posCentreX = new SimpleDoubleProperty();
        public double getPosCentreX() { return posCentreX.get(); }
        public void setPosCentreX(double posCentreX) { this.posCentreX.set(posCentreX); }
        public SimpleDoubleProperty posCentreXProperty() { return posCentreX; }

    private SimpleDoubleProperty posCentreY = new SimpleDoubleProperty();
        public double getPosCentreY() { return posCentreY.get(); }
        public void setPosCentreY(double posCentreY) { this.posCentreY.set(posCentreY); }
        public SimpleDoubleProperty posCentreYProperty() { return posCentreY; }


    public Personnage(double x, double y, double hauteur, double largeur){
        setPosX(x);
        setPosY(y);
        setHauteur(hauteur);
        setLargeur(largeur);
    }
}
