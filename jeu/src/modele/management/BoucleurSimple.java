package modele.management;

import javafx.beans.property.SimpleListProperty;
import modele.deplaceur.Deplaceur;
import modele.personnage.Personnage;

import java.util.ArrayList;

public class BoucleurSimple extends BoucleDeJeu{

    public BoucleurSimple(SimpleListProperty<Personnage> listPersonnage, Deplaceur deplaceur) {
        super(listPersonnage, deplaceur);
    }
}
