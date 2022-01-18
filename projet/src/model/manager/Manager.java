package model.manager;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import model.boucle.BoucleDeplacement;
import model.boucle.BoucleTemps;
import model.boucle.Boucleur;
import model.deplacement.Collisionneur;
import model.deplacement.CollisionneurClassique;
import model.deplacement.Deplaceur;
import model.deplacement.DeplaceurClassique;
import model.entite.*;

public class Manager {
    private Personnage joueur;
    private Collisionneur collisionneur;
    private Deplaceur deplaceur;
    private Mouse mouse;
    private Ligne ligne;
    private Calculateur calculateur;


    private Boucleur boucleTemps;
    private Boucleur boucleDeplacement;

    private Timer timer;

    public Manager(){
        joueur = new Joueur(100, 200, 20, 20);
        collisionneur = new CollisionneurClassique();
        deplaceur = new DeplaceurClassique(collisionneur, joueur);
        mouse = new Mouse();
        timer = new Timer(0, 0);


        boucleTemps = new BoucleTemps();
        boucleTemps.ajouterObservateur(timer);
        new Thread(boucleTemps).start();

        boucleDeplacement = new BoucleDeplacement();
        boucleDeplacement.ajouterObservateur(deplaceur);
        new Thread(boucleDeplacement).start();

    }

    public Personnage getJoueur(){
        return joueur;
    }

    public Collisionneur getCollisionneur(){
        return collisionneur;
    }

    public Deplaceur getDeplaceur(){
        return deplaceur;
    }

    public Mouse getMouse(){
        return mouse;
    }

    public Timer getTimer(){
        return timer;
    }

}
