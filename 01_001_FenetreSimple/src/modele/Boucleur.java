package modele;

import javafx.application.Platform;

import java.util.ArrayList;

//Le mettre dans un package boucleur
public class Boucleur implements Runable {
    private List<Observeur>  observatuers= new ArrayList<>();

    public void ajouterObservateur(Observateur o){
        Observeur.add(o);

    }

    public void beep(){
        observatuers.forEach(o-> Platform.runlater()->o.update());
    }
}
