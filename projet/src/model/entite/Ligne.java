package model.entite;

import javafx.beans.property.SimpleDoubleProperty;

/**
 * Classe de la ligne du joueur
 */
public class Ligne {

    //Création de 2 propriétes pour la fin de la ligne en X et en Y
    private SimpleDoubleProperty posEndLineX = new SimpleDoubleProperty();
    public double getPosEndLineX() { return posEndLineX.get(); }
    public void setPosEndLineX(double posEndLineX) { this.posEndLineX.set(posEndLineX); }
    public SimpleDoubleProperty posEndLineXProperty() { return posEndLineX; }

    private SimpleDoubleProperty posEndLineY = new SimpleDoubleProperty();
    public double getPosEndLineY() { return posEndLineY.get(); }
    public void setPosEndLineY(double posEndLineY) { this.posEndLineY.set(posEndLineY); }
    public SimpleDoubleProperty posEndLineYProperty() { return posEndLineY; }

    public Ligne(double xEnd, double yEnd){
        setPosEndLineX(xEnd);
        setPosEndLineY(yEnd);
    }

    public void updatePosEndLine(double x, double y){
        setPosEndLineX(x);
        setPosEndLineY(y);
    }
}
