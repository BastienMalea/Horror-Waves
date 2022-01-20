package model.deplacement;

import model.entite.Personnage;


/**
 * Classe qui va implémenter les méthodes abstraites de la classe Collisionneur
 */
public class CollisionneurClassique extends Collisionneur{

    //Coordonnée X de la fenêtre du milieu
    private final int OFFSET_X_WINDOW = 315;
    //Coordonnée Y de la fenêtre du milieu
    private final int OFFSET_Y_WINDOW = 175;
    //Bordure de la fenêtre principale
    private final int OFFSET_WINDOW = 15;

    /**
     * Methode qui verifie la collision entre un personnage est la bordure de la fenêtre du milieu
     * @param x coordonée x du personnage
     * @param y coordonée y du personnage
     * @param p Personnage
     * @return Boolean
     */
    @Override
    public Boolean isCollision(double x, double y, Personnage p) {
        Boolean etat;
        etat = x < 310 ||
               x > getlargeurFenetre() - p.getHitBoxLargeur() - OFFSET_X_WINDOW ||
               y < 150 ||
               y > gethauteurFenetre() - p.getHitBoxHauteur() - OFFSET_Y_WINDOW + OFFSET_WINDOW;
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
        if(x+p.getHitBoxLargeur()>x2 && x+p.getHitBoxLargeur()<x2+p2.getHitBoxLargeur() && y+p.getHitBoxHauteur()>y2 && y+p.getHauteur()<y2+p2.getHauteur())
            return true;
        //Collision de gauche a droite + bas en haut
        if(x+p.getHitBoxLargeur()>x2 && x+p.getHitBoxLargeur()<x2+p2.getHitBoxLargeur() && y>y2 && y<y2+p2.getHauteur())
            return true;
        //Collision de droite a gauche + haut en bas
        if(x>x2 && x<x2+p2.getHitBoxLargeur() && y+p.getHitBoxHauteur()>y2 && y+p.getHauteur()<y2+p2.getHauteur())
            return true;
        //Collision de droite a gauche + bas en haut
        if(x>x2 && x<x2+p2.getHitBoxLargeur() && y>y2 && y<y2+p2.getHauteur())
            return true;
        return false;
    }
}
