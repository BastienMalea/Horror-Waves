package modele.deplaceur;

import modele.personnage.Personnage;

public class Deplaceur {

    public Deplaceur(){}

    public void seDeplacer(int x, int y, Personnage p)
    {
        //Demande au collisionner si on peut se deplacer aux coordonnées passées en param
        if(isCollision(x, y)){
            p.setX(x);
            p.setY(y);
        }
        else


    }
}
