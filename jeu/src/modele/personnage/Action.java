package modele.personnage;

import modele.item.Arme;
import modele.item.Item;
import modele.item.Munition;
import modele.item.Power;

public interface Action {
    public void ramasser(Item i);
    public void updateMunition(Munition m);
    public void ramasserArme(Arme a);
    public void ajouterPower(Power p);
    public void supprimerPower(Power p);
    public void changerArmeActive();
    public void attaquer(Personnage p);
}
