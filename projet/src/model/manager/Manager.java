package model.manager;

import javafx.beans.property.ListProperty;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.transform.Scale;
import model.affichage.Affichage;
import model.affichage.AffichageViseur;
import model.boucle.BoucleAffichage;
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
    private Deplaceur deplaceurJoueur;
    private DeplaceurMechant deplaceurMechant;
    private Mouse mouse;
    private Ligne ligne;
    private Calculateur calculateur;
    private Affichage affichageViseur;


    private Boucleur boucleTemps;
    private Boucleur boucleDeplacement;
    private Boucleur boucleAffichage;

    private Timer timer;

    public Manager(){
        joueur = new Joueur(250, 200, 20, 20);
        monstre = new Monstre(15,15,10,10);
        ligne = new Ligne(250, 200);
        mouse = new Mouse();
        timer = new Timer(0, 0);

        collisionneur = new CollisionneurClassique();
        deplaceurJoueur = new DeplaceurClassique(collisionneur, joueur);
        deplaceurMechant = new DeplaceurMechant(collisionneur, monstre, this);

        calculateur = new Calculateur();
        affichageViseur = new AffichageViseur(calculateur, ligne, joueur, mouse);




        boucleTemps = new BoucleTemps();
        boucleTemps.ajouterObservateur(timer);
        new Thread(boucleTemps).start();

        boucleDeplacement = new BoucleDeplacement();
        boucleDeplacement.ajouterObservateur(deplaceurJoueur);
        boucleDeplacement.ajouterObservateur(deplaceurMechant);
        new Thread(boucleDeplacement).start();

        boucleAffichage = new BoucleAffichage();
        boucleAffichage.ajouterObservateur(affichageViseur);
        new Thread(boucleAffichage).start();

    }

    public Personnage getJoueur(){
        return joueur;
    }

    public Collisionneur getCollisionneur(){
        return collisionneur;
    }

    public DeplaceurClassique getDeplaceur(){return (DeplaceurClassique) deplaceurJoueur;}

    public Mouse getMouse(){
        return mouse;
    }

    public Timer getTimer(){
        return timer;
    }

    public Personnage getMonstre(){return monstre;}

    public Ligne getLigne(){
        return ligne;
    }

    public Calculateur getCalculateur(){
        return calculateur;
    }

}
