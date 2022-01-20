package model.deplacement;

import model.entite.Personnage;

public class CollisionneurClassique extends Collisionneur{

    private final int OFFSET_X_WINDOW = 315;
    private final int OFFSET_Y_WINDOW = 175;
    private final int OFFSET_WINDOW = 15;

    /**
     * Methode qui verifie la collision entre un personnage est la bordure de la fenêtre
     * @param x coordonée x du personnage
     * @param y coordonée y du personnage
     * @param p Personnage
     * @return Boolean
     */
    @Override
    public Boolean isCollision(double x, double y, Personnage p) {
        Boolean etat;
        etat = x < 300 ||
               x > getlargeurFenetre() - p.getHitBoxLargeur() - OFFSET_X_WINDOW ||
               y < 130 ||
               y > gethauteurFenetre() - p.getHitBoxHauteur() - OFFSET_Y_WINDOW;
        return etat;
    }

    @Override
    public Boolean isCollisionMonstreWindow(double x, double y, Personnage p){
        Boolean etat;
        etat = x < 0 ||
                x > getlargeurFenetre() - p.getHitBoxLargeur() - OFFSET_WINDOW ||
                y < 0 ||
                y > gethauteurFenetre() - p.getHitBoxHauteur() - OFFSET_WINDOW*2.5;
        return etat;
    }



    /**
     * Methode qui définit s'il y a collision entre deux personnages
     * @param p Premier Personnage
     * @param p2 Deuxieme Personnage
     * @return Boolean
     */
    @Override
    public Boolean isCollisionEntity(Personnage p, Personnage p2)
    {
        double x=p.getPosX();
        double x2=p2.getPosX();
        double y=p.getPosY();
        double y2=p2.getPosY();
        //Collision de gauche a droite + haut en bas
        if(x+p.getLargeur()>x2 && x+p.getLargeur()<x2+p2.getHitBoxLargeur() && y+p.getHauteur()>y2 && y+p2.getHauteur()<y2+p2.getHauteur())
            return true;
        //Collision de gauche a droite + bas en haut
        if(x+p.getLargeur()>x2 && x+p.getLargeur()<x2+p2.getHitBoxLargeur() && y>y2 && y<y2+p2.getHauteur())
            return true;
        if(x>x2 && x<x2+p2.getHitBoxLargeur() && y+p.getHauteur()>y2 && y+p2.getHauteur()<y2+p2.getHauteur())
            return true;
        //Collision de droite a gauche + bas en haut
        if(x>x2 && x<x2+p2.getHitBoxLargeur() && y>y2 && y<y2+p2.getHauteur())
            return true;
        return false;
    }
}
