package model.deplacement;

import javafx.scene.input.KeyCode;
import model.entite.Personnage;

import java.util.ArrayList;
import java.util.List;

public class DeplaceurClassique extends Deplaceur{
    private double STEP = 6.0;
    private List<KeyCode> listeTouche = new ArrayList<KeyCode>();
    private Personnage joueur;

    public DeplaceurClassique(Collisionneur collisionneur, Personnage joueur){
        super(collisionneur);
        this.joueur = joueur;
    }


    public void ajouterTouche(KeyCode code){
        if(!listeTouche.contains(code))
            listeTouche.add(code);
    }

    public void supprimerTouche(KeyCode code){
        if(listeTouche.contains(code))
            listeTouche.remove(code);
    }



    @Override
    public void update() {
        if(listeTouche.size() == 2){
            STEP = (STEP*5)/6;
        }
        if(listeTouche.contains(KeyCode.UP))
            if(!collisionneur.isCollision(joueur.getPosX(), joueur.getPosY() - STEP, joueur))
                joueur.setPosY(joueur.getPosY() - STEP);

        if(listeTouche.contains(KeyCode.DOWN))
            if(!collisionneur.isCollision(joueur.getPosX(), joueur.getPosY() + STEP, joueur))
                joueur.setPosY(joueur.getPosY() + STEP);

        if(listeTouche.contains(KeyCode.LEFT))
            if(!collisionneur.isCollision(joueur.getPosX() - STEP, joueur.getPosY(), joueur))
                joueur.setPosX(joueur.getPosX() - STEP);

        if(listeTouche.contains(KeyCode.RIGHT))
            if(!collisionneur.isCollision(joueur.getPosX() + STEP, joueur.getPosY(), joueur))
                joueur.setPosX(joueur.getPosX() + STEP);

        if(listeTouche.size() == 2){
            STEP = (STEP*6)/5;
        }
    }
}
