package modele.management;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import modele.deplaceur.Deplaceur;
import modele.item.Arme;
import modele.personnage.Joueur;
import modele.personnage.Personnage;


import java.sql.Array;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Manager {
    private ArrayList<Personnage> listePersonnage;


    public Manager(){
        listePersonnage = new ArrayList<Personnage>();
        listePersonnage.add(new Joueur("joueur", 3, 10, 190, 20, 0, "chemin vers image", 30, 20));
    }

    //getter setter listePersonnage
    public ArrayList<Personnage> getListePersonnage(){
        return listePersonnage;
    }
    public void setListePersonnage(ArrayList<Personnage> listePersonnage){
        this.listePersonnage = listePersonnage;
    }

    //fonction afficher listePersonnage
    public void afficherListePersonnage(){
        listePersonnage.forEach((p) -> System.out.println(p));
    }
    //fonction get joueur principal
    public Personnage getJoueur(){
        return listePersonnage.get(0);
    }


    public void jeu(Scene scene) throws InterruptedException {
        Deplaceur deplaceur = new Deplaceur(scene, listePersonnage);
        BoucleDeJeu bdj = new BoucleDeJeu(listePersonnage, deplaceur);

        Thread thread = new Thread(bdj);
        thread.start();

        deplaceur.detectionTouche();

    }
}
