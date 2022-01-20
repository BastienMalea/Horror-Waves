package model.entite;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import model.boucle.Observeur;

/**
 * Classe du timer d'une partie
 */
public class Timer extends Observeur {

    //Propriété du temps
    private SimpleIntegerProperty temps = new SimpleIntegerProperty();
        public int getTemps() { return temps.get(); }
        public void setTemps(int temps) { this.temps.set(temps); }
        public SimpleIntegerProperty tempsProperty() { return temps; }

    // Propriété de la coordonée x
    private SimpleDoubleProperty posX = new SimpleDoubleProperty();
        public double getPosX() { return posX.get(); }
        public void setPosX(double posX) { this.posX.set(posX); }
        public SimpleDoubleProperty posXProperty() { return posX; }

    // Propriété de la coordonée y
    private SimpleDoubleProperty posY = new SimpleDoubleProperty();
        public double getPosY() { return posY.get(); }
        public void setPosY(double posY) { this.posY.set(posY); }
        public SimpleDoubleProperty posYProperty() { return posY; }


    /**
     * Constructeur du Timer
     * @param x  coordonée x
     * @param y  coordonée y
     */
    public Timer(double x, double y){
        setPosX(x);
        setPosY(y);
        //Set le timer à 0
        setTemps(0);
    }

    /**
     * Methode qui incrémente le timer de 1 a chaque fois que le update est appelé
     */
    @Override
    public void update() {
        setTemps(getTemps() + 1);
    }
}
