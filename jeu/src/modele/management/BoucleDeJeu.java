package modele.management;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import modele.deplaceur.Deplaceur;
import modele.personnage.Personnage;

import java.util.ArrayList;
import java.util.Observable;

public class BoucleDeJeu implements Runnable{
    private ArrayList<Personnage> listePersonnage;
    private SimpleListProperty<Personnage> listPersonnage;
    private Deplaceur deplaceur;


    //Mise en commentaire pour tester avec la SimpleListProperty
    /**public BoucleDeJeu(ArrayList<Personnage> listePersonnage, Deplaceur deplaceur){
        this.listePersonnage = listePersonnage;
        this.deplaceur=deplaceur;
    }**/

    public BoucleDeJeu(SimpleListProperty<Personnage> listPersonnage, Deplaceur deplaceur){
        this.listPersonnage = listPersonnage;
        this.deplaceur=deplaceur;
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
