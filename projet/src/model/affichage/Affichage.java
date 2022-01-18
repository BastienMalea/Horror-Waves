package model.affichage;

import model.boucle.Observeur;
import model.entite.Ligne;
import model.manager.Calculateur;

public abstract class Affichage extends Observeur {

    protected Calculateur calculateur;

    public Affichage(Calculateur calculateur){
        this.calculateur = calculateur;
    };

}
