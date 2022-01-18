package model.deplacement;

import model.boucle.Observeur;
import model.entite.Joueur;
import model.entite.Monstre;
import model.entite.Personnage;
import model.manager.Manager;

public class DeplaceurMechant extends Deplaceur {

    private Manager manager;
    private Monstre monstre;
    private final int STEP = 2;

    public DeplaceurMechant(Collisionneur collisionneur, Personnage monstre, Manager manager)
    {
        super(collisionneur);
        this.monstre= (Monstre) monstre;
        this.manager=manager;
    }

    @Override
    public void update() {
        if(manager.getJoueur().getPosX()-monstre.getPosX()<0)
            if(!collisionneur.isCollision(monstre.getPosX(), monstre.getPosY() - STEP, monstre))
                monstre.setPosX(monstre.getPosX() - STEP);
        if(manager.getJoueur().getPosX()-monstre.getPosX()>0)
            if(!collisionneur.isCollision(monstre.getPosX(), monstre.getPosY() + STEP, monstre))
                monstre.setPosX(monstre.getPosX() + STEP);
        if(manager.getJoueur().getPosY()-monstre.getPosY()<0)
            if(!collisionneur.isCollision(monstre.getPosX(), monstre.getPosY() - STEP, monstre))
                monstre.setPosY(monstre.getPosY() - STEP);
        if(manager.getJoueur().getPosY()-monstre.getPosY()>0)
            if(!collisionneur.isCollision(monstre.getPosX(), monstre.getPosY() + STEP, monstre))
                monstre.setPosY(monstre.getPosY() + STEP);
    }
}
