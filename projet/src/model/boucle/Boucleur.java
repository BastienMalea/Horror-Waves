package model.boucle;

import javafx.application.Platform;
import javafx.beans.Observable;

import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe mère des autres boucles
 */
public abstract class Boucleur implements Runnable {

    private List<Observeur> observateur = new ArrayList<>();


    public void ajouterObservateur(Observeur o){
        observateur.add(o);
    }

    /**
     * Méthode qui envoie le signal à tout les Observeurs
     */
    public void beep(){
        for(Observeur o : observateur){
            Platform.runLater(() -> o.update());
        }
    }

}
