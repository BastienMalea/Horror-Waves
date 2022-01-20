package model.affichage;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import model.entite.Monstre;
import model.entite.Personnage;
import model.manager.Manager;

import java.util.ArrayList;
import java.util.List;

public class AfficheurMonstre extends Afficheur{
    private Manager manager;
    /**
     * permet de savoir si un personnage se déplace à gauche ou a droite en comparant avec la position actuelle
     */
    private List<Double> oldX;

    /**
     * constructeur de l'afficheur de monstre
     * @param manager
     */
    public AfficheurMonstre(Manager manager){
        this.manager = manager;
        this.oldX = new ArrayList<Double>();
    }

    /**
     * parcour la liste de monstre et actualise l'affichage de chacun.
     * si il va à droite, l'image montre un monstre tourné vers la droite
     * si il va à gauche, l'image montre un monstre tourné vers la gauche
     */
    @Override
    public void update() {
        int i = 0;
        String imgLink;

        if(!manager.getListeMonstre().isEmpty())
            for(Personnage monstre: manager.getListeMonstre()){
                switch(((Monstre)monstre).getType()){
                    case 0: imgLink = "Image/MechantPetit/Tiny"; break;
                    case 1: imgLink = "Image/MechantRouge/Red"; break;
                    default : imgLink = "Image/Ours/Bear"; break;
                }
                if(oldX.get(i) < monstre.getPosX()){
                    Image img = new Image(imgLink + "2.png", monstre.getHauteur(), monstre.getLargeur(), false, true);
                    ((Rectangle)manager.getVueJeu().getListeMonstreVue().getChildren().get(i)).setFill(new ImagePattern(img));
                }
                if(oldX.get(i) > monstre.getPosX()){
                    Image img = new Image(imgLink + ".png", monstre.getHauteur(), monstre.getLargeur(), false, true);
                    ((Rectangle)manager.getVueJeu().getListeMonstreVue().getChildren().get(i)).setFill(new ImagePattern(img));
                }
                oldX.set(i, monstre.getPosX());
                i++;
            }
    }

    /**
     * ajouter la coordonnée d'un monstre la frame ou il est crée
     * @param x
     */
    public void addOldX(double x){
        this.oldX.add(x);
    }
}
