package model.affichage;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import model.entite.Personnage;
import model.manager.Manager;

public class AfficheurPersonnage extends Afficheur{
    private Manager manager;
    private Personnage joueur;
    private double oldX;

    public AfficheurPersonnage(Manager manager){
        this.manager = manager;
        this.joueur = manager.getJoueur();
        this.oldX = joueur.getPosX();
    }

    @Override
    public void update() {
        if(oldX < joueur.getPosX()){
            Image img = new Image("Image/Perso/Pink_Monster.png",
                    joueur.getHauteur(), joueur.getLargeur(),
                    false, true);
            manager.getVueJeu().getJoueurVue().setFill(new ImagePattern(img));
        }
        if(oldX > joueur.getPosX()){
            Image img = new Image("Image/Perso/Pink_Monster2.png",
                    joueur.getHauteur(), joueur.getLargeur(),
                    false, true);
            manager.getVueJeu().getJoueurVue().setFill(new ImagePattern(img));
        }
        oldX = joueur.getPosX();
    }
}
