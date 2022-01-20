package model.manager;

import model.affichage.AfficheurMonstre;
import model.boucle.Observeur;
import java.util.Random;

public class CreateurMonstre extends Observeur {

    private Manager manager;

    /**
     * constructeur
     * @param manager
     */
    public CreateurMonstre(Manager manager){
        this.manager = manager;
    }

    /**
     * génère des coordonnés aléatoire dans une certaine zone ou le spawn est possible
     * génère aléatoirement un type de monstre
     */
    @Override
    public void update() {
        Random rand = new Random();
        int x;
        int y;
        int type;

        if(rand.nextInt((1-0)+1)-0 == 0){
            x = rand.nextInt((300-50)+1)+50;
        }
        else{
            x = rand.nextInt((1100-885)+1) + 885;
        }

        if(rand.nextInt((1-0)+1)-0 == 0){
            y = rand.nextInt((130-50)+1)+50;
        }
        else{
            y = rand.nextInt((700-625)+1) + 625;
        }

        type = rand.nextInt((2-0)+1)+0;

        ((AfficheurMonstre)manager.getAfficheurMonstre()).addOldX(x);
        manager.creerMonstre(x, y, type);
    }
}
