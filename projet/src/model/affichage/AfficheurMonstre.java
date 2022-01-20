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
    private List<Double> oldX;

    public AfficheurMonstre(Manager manager){
        this.manager = manager;
        this.oldX = new ArrayList<Double>();
    }

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

    public void addOldX(double x){
        this.oldX.add(x);
    }
}
