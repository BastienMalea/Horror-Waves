package model.affichage;

import model.boucle.Observeur;
import model.manager.Calculateur;

public abstract class Afficheur extends Observeur {

    protected Calculateur calculateur;

    public Afficheur(Calculateur calculateur){
        this.calculateur = calculateur;
    };

}
