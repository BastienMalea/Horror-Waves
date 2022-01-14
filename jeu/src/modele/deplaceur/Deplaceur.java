package modele.deplaceur;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import modele.management.Collisionneur;
import modele.personnage.Personnage;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Deplaceur {
    Scene scene;
    Personnage joueur;
    //ArrayList<Personnage> listePersonnage;
    SimpleListProperty<Personnage> listPersonnage;
    ArrayList<String> listeMouvement = new ArrayList<String>();

/**
    public Deplaceur(Scene scene, ArrayList<Personnage> listePersonnage){
        this.scene = scene;
        this.listePersonnage = listePersonnage;
        this.joueur = listePersonnage.get(0);
    }
**/
    public Deplaceur(Scene scene, SimpleListProperty<Personnage> listPersonnage){
        this.scene = scene;
        this.listPersonnage = listPersonnage;
        this.joueur = listPersonnage.get(0);
    }

    public void detectionTouche()
    {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch(event.getCode()){
                    case UP:
                        if(!listeMouvement.contains("U")) {
                            listeMouvement.add("U");
                        }
                        break;
                    case DOWN:
                        if(!listeMouvement.contains("D")) {
                            listeMouvement.add("D");
                        }
                        break;
                    case LEFT:
                        if(!listeMouvement.contains("L")) {
                            listeMouvement.add("L");
                        }
                        break;
                    case RIGHT:
                        if(!listeMouvement.contains("R")) {
                            listeMouvement.add("R");
                        }
                        break;
                }
            }
        });
    }


    public void updatePositionJoueur() {
        if(listeMouvement.contains("U")){
            System.out.println("y = " + joueur.getPosY());
            joueur.setPosY(joueur.getPosY() - 1);
        }
        if(listeMouvement.contains("D")){
            System.out.println("y = " + joueur.getPosY());
            joueur.setPosY(joueur.getPosY() + 1);
        }
        if(listeMouvement.contains("L")){
            System.out.println("x = " + joueur.getPosX());
            joueur.setPosX(joueur.getPosX() - 1);
        }
        if(listeMouvement.contains("R")){
            System.out.println("x = " + joueur.getPosX());
            joueur.setPosX(joueur.getPosX() + 1);
        }
        listeMouvement.clear();

    }
}
