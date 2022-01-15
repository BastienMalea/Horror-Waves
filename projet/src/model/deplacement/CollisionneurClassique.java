package model.deplacement;

import model.entite.Personnage;

public class CollisionneurClassique extends Collisionneur{

    private final int OFFSET_WINDOW = 15;

    @Override
    public Boolean isCollision(double x, double y, Personnage p) {
        Boolean etat;
        etat = x < 0 ||
               x > getlargeurFenetre() - 20 - OFFSET_WINDOW ||
               y < 0 ||
               y > gethauteurFenetre() - 20 - OFFSET_WINDOW*2.5;
        return etat;
    }
}
