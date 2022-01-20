package model.deplacement;

import model.boucle.Observeur;
import model.entite.Joueur;
import model.entite.Monstre;
import model.entite.Personnage;
import model.manager.Manager;

public class DeplaceurMechant extends Deplaceur {

    private Manager manager;
    private double STEP = 3;

    public DeplaceurMechant(Collisionneur collisionneur, Manager manager)
    {
        super(collisionneur);
        this.manager=manager;
    }

    @Override
    public void update() {
        if(!manager.getListeMonstre().isEmpty())
            for(Personnage monstre: manager.getListeMonstre()){
                if(manager.getJoueur().getPosCentreX()-monstre.getPosCentreX()<0)
                    if(!collisionneur.isCollisionMonstreWindow(monstre.getPosX(), monstre.getPosY() - STEP, monstre) &&
                    !collisionneur.isCollisionEntity(monstre, manager.getJoueur()))
                        monstre.setPosX(monstre.getPosX() - STEP);
                if(manager.getJoueur().getPosCentreX()-monstre.getPosCentreX()>0)
                    if(!collisionneur.isCollisionMonstreWindow(monstre.getPosX(), monstre.getPosY() + STEP, monstre) &&
                            !collisionneur.isCollisionEntity(monstre, manager.getJoueur()))
                        monstre.setPosX(monstre.getPosX() + STEP);
                    //Deplacement en haut
                if(manager.getJoueur().getPosCentreY()-monstre.getPosCentreY()<0)
                    if(!collisionneur.isCollisionMonstreWindow(monstre.getPosX(), monstre.getPosY() - STEP, monstre) &&
                            !collisionneur.isCollisionEntity(monstre, manager.getJoueur()))
                        monstre.setPosY(monstre.getPosY() - STEP);
                    //Deplacement en bas
                if(manager.getJoueur().getPosCentreY()-monstre.getPosCentreY()>0)
                    if(!collisionneur.isCollisionMonstreWindow(monstre.getPosX(), monstre.getPosY() + STEP, monstre) &&
                            !collisionneur.isCollisionEntity(monstre, manager.getJoueur()))
                        monstre.setPosY(monstre.getPosY() + STEP);
            }
    }
}
