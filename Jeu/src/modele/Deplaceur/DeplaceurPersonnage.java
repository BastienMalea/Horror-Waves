package modele.Deplaceur;

import modele.Personnage;

public class DeplaceurPersonnage {

    //La méthode du coup je savais plus ce qu'on avait dit mais elle change juste le posX et posY du personnage en paramètre ou rien a voir
    private void seDeplacer(int x, int y, Personnage p)
    {
        p.setX(y);
        p.setY(y);
    }
}
