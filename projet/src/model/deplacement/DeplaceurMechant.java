package model.deplacement;

import model.boucle.Observeur;
import model.entite.Joueur;
import model.entite.Monstre;
import model.entite.Personnage;
import model.manager.Manager;

/**
 * Classe qui va déplacer les méchants / Monstres
 */
public class DeplaceurMechant extends Deplaceur {

    private Manager manager;
    //Vitesse de déplacement des monstres
    private double STEP = 2.5;

    public DeplaceurMechant(Collisionneur collisionneur, Manager manager)
    {
        super(collisionneur);
        this.manager=manager;
    }

    /**
     * Méthode update du déplaceur des monstres
     * Les monstres se déplacent vers le centre du joueur
     */
    @Override
    public void update() {
        //On vérifie que la liste monstre n'est pas vide
        if(!manager.getListeMonstre().isEmpty())
            //Parcours de la liste de Monstre
            for(Personnage monstre: manager.getListeMonstre()){
                //Si le joueur est à gauche du monstre
                if(manager.getJoueur().getPosCentreX()-monstre.getPosCentreX()<0)
                    //Vérification que le monstre ne sorte pas de la fenêtre principale et vérification qu'il n'y ait pas de collision entre le monstre et le joueur
                    if(!collisionneur.isCollisionMonstreWindow(monstre.getPosX(), monstre.getPosY() - STEP, monstre) &&
                    !collisionneur.isCollisionEntity(monstre, manager.getJoueur()))
                        //Déplacement vers la gauche
                        monstre.setPosX(monstre.getPosX() - STEP);
                    //Si le joueur est à droite du monstre
                if(manager.getJoueur().getPosCentreX()-monstre.getPosCentreX()>0)
                    //Vérification que le monstre ne sorte pas de la fenêtre principale et vérification qu'il n'y ait pas de collision entre le monstre et le joueur
                    if(!collisionneur.isCollisionMonstreWindow(monstre.getPosX(), monstre.getPosY() + STEP, monstre) &&
                            !collisionneur.isCollisionEntity(monstre, manager.getJoueur()))
                        //Déplacement du monstre vers la droite
                        monstre.setPosX(monstre.getPosX() + STEP);
                    //Deplacement en haut
                if(manager.getJoueur().getPosCentreY()-monstre.getPosCentreY()<0)
                    //Vérification que le monstre ne sorte pas de la fenêtre principale et vérification qu'il n'y ait pas de collision entre le monstre et le joueur
                    if(!collisionneur.isCollisionMonstreWindow(monstre.getPosX(), monstre.getPosY() - STEP, monstre) &&
                            !collisionneur.isCollisionEntity(monstre, manager.getJoueur()))
                        //Déplacement du monstre vers le haut
                        monstre.setPosY(monstre.getPosY() - STEP);
                    //Deplacement en bas
                if(manager.getJoueur().getPosCentreY()-monstre.getPosCentreY()>0)
                    //Vérification que le monstre ne sorte pas de la fenêtre principale et vérification qu'il n'y ait pas de collision entre le monstre et le joueur
                    if(!collisionneur.isCollisionMonstreWindow(monstre.getPosX(), monstre.getPosY() + STEP, monstre) &&
                            !collisionneur.isCollisionEntity(monstre, manager.getJoueur()))
                        //Déplacement du monstre vers le bas
                        monstre.setPosY(monstre.getPosY() + STEP);
            }
    }
}
