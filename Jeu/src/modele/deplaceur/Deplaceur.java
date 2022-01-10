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
    Personnage joueur;
    ArrayList<Personnage> listePersonnage;
    ArrayList<String> listeMouvement = new ArrayList<String>();


    public Deplaceur(Scene scene, ArrayList<Personnage> listePersonnage){
        this.scene = scene;
        this.listePersonnage = listePersonnage;
        this.joueur = listePersonnage.get(0);
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
