package modele;

public abstract class Collisionneur {

    public double hauteurFenetre;  <--- Les faires en proprietes (Double Property comme dans entite)
    public double largeruFenetre;
    public abstract boolean isCollision(double x, double y, Entite e);
}
