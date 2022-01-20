package model.affichage;

import model.boucle.Observeur;
import model.entite.Personnage;
import model.manager.Manager;

public class EtatJoueur extends Observeur {

    Manager manager;

    public EtatJoueur(Manager manager) {
        this.manager=manager;
    }

    @Override
    public void update() {
        for(Personnage monstre: manager.getListeMonstre()) {
            if (manager.getCollisionneur().isCollisionEntity(manager.getJoueur(), monstre));
                manager.getJoueur().setPv(manager.getJoueur().getPv()-1);
        }
    }
}
