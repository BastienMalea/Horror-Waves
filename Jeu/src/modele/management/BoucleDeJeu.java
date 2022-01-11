package modele.management;

import javafx.collections.ObservableList;
import modele.deplaceur.Deplaceur;
import modele.personnage.Personnage;

import java.util.ArrayList;
import java.util.Observable;

public class BoucleDeJeu implements Runnable{
    private ArrayList<Personnage> listePersonnage;
    private Deplaceur deplaceur;

    public BoucleDeJeu(ArrayList<Personnage> listePersonnage, Deplaceur deplaceur){
        this.listePersonnage = listePersonnage;
        this.deplaceur = deplaceur;
    }

    @Override
    public void run(){
        while(true) {
            deplaceur.updatePositionJoueur();

            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
