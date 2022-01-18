package model.entite;

import javafx.beans.property.SimpleDoubleProperty;

public class Mouse {
    private SimpleDoubleProperty posMouseX = new SimpleDoubleProperty();
    public double getPosMouseX() { return posMouseX.get(); }
    public void setPosMouseX(double posMouseX) { this.posMouseX.set(posMouseX); }
    public SimpleDoubleProperty posMouseXProperty() { return posMouseX; }

    private SimpleDoubleProperty posMouseY = new SimpleDoubleProperty();
    public double getPosMouseY() { return posMouseY.get(); }
    public void setPosMouseY(double posMouseY) { this.posMouseY.set(posMouseY); }
    public SimpleDoubleProperty posMouseYProperty() { return posMouseY; }

    public Mouse(){}

    public void updateCoordonnees(double x, double y){
        this.setPosMouseX(x);
        this.setPosMouseY(y);
    }
}
