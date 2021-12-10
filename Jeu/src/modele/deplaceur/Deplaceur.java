package modele.deplaceur;

import modele.personnage.Personnage;

public class Deplaceur {

    public Deplaceur(){}

    public void seDeplacer(int x, int y, Personnage p)
    {
        p.setX(x);
        p.setY(y);
    }
}
