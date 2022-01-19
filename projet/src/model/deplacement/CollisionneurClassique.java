package model.deplacement;

import model.entite.Personnage;

public class CollisionneurClassique extends Collisionneur{

    private final int OFFSET_WINDOW = 15;

    @Override
    public Boolean isCollision(double x, double y, Personnage p) {
        Boolean etat;
        etat = x < 0 ||
               x > getlargeurFenetre() - p.getHitBoxLargeur() - OFFSET_WINDOW ||
               y < 0 ||
               y > gethauteurFenetre() - p.getHitBoxHauteur() - OFFSET_WINDOW*2.5;
        return etat;
    }

    public Boolean isCollisionEntity(Personnage p, Personnage p2)
    {
        double x=p.getPosX();
        double x2=p2.getPosX();
        double y=p.getPosY();
        double y2=p2.getPosY();
        //Collision de gauche a droite + haut en bas
        if(x+p.getLargeur()>x2 && x+p.getLargeur()<x2+p2.getLargeur() && y+p.getHauteur()>y2 && y+p2.getHauteur()<y2+p2.getHauteur())
            return true;
        //Collision de gauche a droite + bas en haut
        if(x+p.getLargeur()>x2 && x+p.getLargeur()<x2+p2.getLargeur() && y>y2 && y<y2+p2.getHauteur())
            return true;
        //Collision de droite a gauche + haut en bas
        if(x>x2 && x<x2+p2.getLargeur() && y+p.getHauteur()>y2 && y+p2.getHauteur()<y2+p2.getHauteur())
            return true;
        //Collision de droite a gauche + bas en haut
        if(x>x2 && x<x2+p2.getLargeur() && y>y2 && y<y2+p2.getHauteur())
            return true;
        //Collision de haut en bas + gauche a droite
        /*if(y+p.getHauteur()>y2 && y+p2.getHauteur()<y2+p2.getHauteur())
            return true;

        //Collision de bas en haut
        if(y>y2 && y<y2+p2.getHauteur())
            return true;
/*
        //Collision de droite a gauche
        if(x>x2 && x<x2+p2.getLargeur())
            return true;
        //Collision de haut en bas
        if(y+p.getHauteur()>y2 && y+p2.getHauteur()<y2+p2.getHauteur())
            return true;
        //Collision de bas en haut
        if(y>y2 && y<y2+p2.getHauteur())
            return true;
        return false;*/
        return false;
    }
}
