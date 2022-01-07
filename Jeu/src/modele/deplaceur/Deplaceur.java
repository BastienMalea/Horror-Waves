package modele.deplaceur;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import modele.management.Collisionneur;
import modele.personnage.Personnage;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Deplaceur implements Observer {
    Scene scene;
    ArrayList<Personnage> listePersonnage;
    ArrayList<String> listeMouvement = new ArrayList<String>();


    public Deplaceur(Scene scene, ArrayList<Personnage> listePersonnage){
        this.scene = scene;
        this.listePersonnage = listePersonnage;
    }

    public void seDeplacer(Personnage p)
    {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch(event.getCode()){
                    case UP:
                        listeMouvement.add("U");
                        break;
                    case DOWN:
                        listeMouvement.add("D");
                        break;
                    case LEFT:
                        listeMouvement.add("L");
                        break;
                    case RIGHT:
                        listeMouvement.add("R");
                        break;
                }
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        if(listeMouvement.contains("U")){
            System.out.println("se déplacer en haut");
        }
        if(listeMouvement.contains("D")){
            System.out.println("se déplacer en bas");
        }
        if(listeMouvement.contains("L")){
            System.out.println("se déplacer à gauche");
        }
        if(listeMouvement.contains("R")){
            System.out.println("se déplacer à droite");
        }
        listeMouvement.clear();
    }
}
