package model.affichage;

import model.boucle.Observeur;
import model.entite.Personnage;
import model.manager.Manager;

public class EtatJoueur extends Observeur {

    Manager manager;

    public EtatJoueur(Manager manager) {
        this.manager=manager;
    }

    public Boolean verifierVie(int pv){
        if(pv==0)
            return true;
        return false;
    }

    @Override
    public void update() {
        for(Personnage monstre: manager.getListeMonstre()) {
            if(manager.getCollisionneur().isCollisionEntity(monstre, manager.getJoueur()))
            {
                if(verifierVie(manager.getJoueur().getPv()))
                    manager.stopPartie();
                else
                    manager.getJoueur().setPv(manager.getJoueur().getPv()-1);
            }

        }
    }
}
