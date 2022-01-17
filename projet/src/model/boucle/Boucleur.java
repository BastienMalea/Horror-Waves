package model.boucle;

import javafx.application.Platform;
import javafx.beans.Observable;

import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

public abstract class Boucleur implements Runnable {

    private List<Observeur> observateur = new ArrayList<>();


    public void ajouterObservateur(Observeur o){
        observateur.add(o);
    }

    public void beep(){
        for(Observeur o : observateur){
            Platform.runLater(() -> o.update());
        }
    }
}
