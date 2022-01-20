package model.affichage;

import model.boucle.Observeur;
import model.entite.Personnage;
import model.manager.Manager;

public class EtatJoueur extends Observeur {

    Manager manager;

    /***
     * constructeur
     * @param manager
     */
    public EtatJoueur(Manager manager) {
        this.manager=manager;
    }

    /**
     * vérifie si le joueur est encore en vie
     * @param pv
     * @return Boolean
     */
    public Boolean verifierVie(int pv){
        if(pv==0)
            return true;
        return false;
    }

    /**
     * si collision entre joueur et monstre:
     * -si le joueur à encore de la vie : vie-1
     * -si le joueur n'a plus assez de vie : GAMEOVER
     */
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
