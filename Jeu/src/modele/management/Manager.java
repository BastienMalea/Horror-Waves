package modele.management;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import modele.deplaceur.Deplaceur;
import modele.item.Arme;
import modele.personnage.Joueur;
import modele.personnage.Personnage;


import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Manager {
    private ArrayList<Personnage> listePersonnage;


    public Manager(){
        listePersonnage = new ArrayList<Personnage>();
        listePersonnage.add(new Joueur("joueur", 3, 150, 150, 20, 0, "chemin vers image", 30, 20));
    }


    public ArrayList<Personnage> getListePersonnage(){
        return listePersonnage;
    }

    public void setListePersonnage(ArrayList<Personnage> listePersonnage){
        this.listePersonnage = listePersonnage;
    }


    public void afficherListePersonnage(){
        listePersonnage.forEach((p) -> System.out.println(p));
    }


    public void jeu(Scene scene) throws InterruptedException {
        BoucleDeJeu bdj = new BoucleDeJeu();
        Deplaceur deplaceur = new Deplaceur(scene, listePersonnage);
        bdj.addObserver(deplaceur);

        Thread thread = new Thread(bdj);
        thread.start();

        deplaceur.seDeplacer(listePersonnage.get(0));


    }
}
