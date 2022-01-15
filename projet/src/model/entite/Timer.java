package model.entite;

import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import model.boucle.Observeur;

public class Timer extends Observeur {

    private SimpleIntegerProperty temps = new SimpleIntegerProperty();
        public int getTemps() { return temps.get(); }
        public void setTemps(int temps) { this.temps.set(temps); }
        public SimpleIntegerProperty tempsProperty() { return temps; }

    private SimpleDoubleProperty posX = new SimpleDoubleProperty();
        public double getPosX() { return posX.get(); }
        public void setPosX(double posX) { this.posX.set(posX); }
        public SimpleDoubleProperty posXProperty() { return posX; }

    private SimpleDoubleProperty posY = new SimpleDoubleProperty();
        public double getPosY() { return posY.get(); }
        public void setPosY(double posY) { this.posY.set(posY); }
        public SimpleDoubleProperty posYProperty() { return posY; }

    public Timer(double x, double y){
        setPosX(x);
        setPosY(y);
    }

    @Override
    public void update() {
        setTemps(getTemps() + 1);
    }
}
