package modele.management;

import javafx.beans.InvalidationListener;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import modele.deplaceur.Deplaceur;
import modele.personnage.Joueur;
import modele.personnage.Personnage;


import java.util.ArrayList;

import static java.lang.Thread.sleep;
import static javafx.collections.FXCollections.observableArrayList;

public class Manager {
    private ArrayList<Personnage> listePersonnage;
    private SimpleListProperty<Personnage> listPersonnage;
    private ObjectProperty<Personnage> test; // YA un autre type j'ai pas eu le temps


    public Manager(){
        listePersonnage = new ArrayList<Personnage>();
        test =  new ObjectListProperty<Personnage>() {

        listePersonnage.add(new Joueur("joueur", 3, 10, 190, 20, 0, "chemin vers image", 30, 20));
        listPersonnage.add(new Joueur("joueur", 3, 10, 190, 20, 0, "chemin vers image", 30, 20));
    }

    public SimpleListProperty<Personnage> getListPersonnage(){
        return listPersonnage;
    }
    public void setListePersonnage(SimpleListProperty<Personnage> listPersonnage){
        this.listPersonnage = listPersonnage;
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

    public Personnage getJoueurByList(){return listPersonnage.get(0);}


    public void jeu(Scene scene) throws InterruptedException {
        //Deplaceur deplaceur = new Deplaceur(scene, listePersonnage);
        Deplaceur deplaceur = new Deplaceur(scene, listPersonnage);
        //BoucleDeJeu bdj = new BoucleDeJeu(listePersonnage, deplaceur);
        BoucleDeJeu bdj = new BoucleDeJeu(listPersonnage, deplaceur);
        Thread thread = new Thread(bdj);
        thread.start();
        deplaceur.detectionTouche();

    }
}
