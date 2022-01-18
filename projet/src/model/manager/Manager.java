package model.manager;

import javafx.beans.property.ListProperty;
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

import model.deplacement.*;
import model.entite.Joueur;
import model.entite.Monstre;
import model.entite.Personnage;
import model.entite.Timer;


public class Manager {
    private Personnage joueur;
    private Personnage monstre;
    //private final ListProperty<Monstre> monstres;
    private Collisionneur collisionneur;
    private Deplaceur deplaceur;
    private Mouse mouse;
    private Ligne ligne;
    private Calculateur calculateur;


    private Boucleur boucleTemps;
    private Boucleur boucleDeplacement;
    private DeplaceurMechant deplaceurMechant;

    private Timer timer;

    public Manager(){
        joueur = new Joueur(250, 200, 20, 20);
        monstre = new Monstre(15,15,10,10);
        collisionneur = new CollisionneurClassique();
        deplaceur = new DeplaceurClassique(collisionneur, joueur);
        deplaceurMechant = new DeplaceurMechant(collisionneur, monstre, this);

        mouse = new Mouse();


        timer = new Timer(0, 0);


        boucleTemps = new BoucleTemps();
        boucleTemps.ajouterObservateur(timer);
        new Thread(boucleTemps).start();

        boucleDeplacement = new BoucleDeplacement();
        boucleDeplacement.ajouterObservateur(deplaceur);
        boucleDeplacement.ajouterObservateur(deplaceurMechant);
        new Thread(boucleDeplacement).start();

    }

    public Personnage getJoueur(){
        return joueur;
    }

    public Collisionneur getCollisionneur(){
        return collisionneur;
    }

    public DeplaceurClassique getDeplaceur(){return (DeplaceurClassique) deplaceur;}

    public Mouse getMouse(){
        return mouse;
    }

    public Timer getTimer(){
        return timer;
    }

    public Personnage getMonstre(){return monstre;}

}
