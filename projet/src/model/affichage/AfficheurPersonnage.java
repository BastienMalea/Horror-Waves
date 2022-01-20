package model.affichage;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import model.entite.Personnage;
import model.manager.Manager;

public class AfficheurPersonnage extends Afficheur{
    private Manager manager;
    private Personnage joueur;
    /**
     * permet de savoir si un personnage se déplace à gauche ou a droite en comparant avec la position actuelle
     */
    private double oldX;

    public AfficheurPersonnage(Manager manager){
        this.manager = manager;
        this.joueur = manager.getJoueur();
        this.oldX = joueur.getPosX();
    }

    /**
     * actualise l'affichage du personnage.
     * si il va à droite, l'image montre un personnage tourné vers la droite
     * si il va à gauche, l'image montre un personnage tourné vers la gauche
     */
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
