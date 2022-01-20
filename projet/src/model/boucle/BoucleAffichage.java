package model.boucle;


/**
 * Classe qui gérera tout les affichages sur la vue des Personnages
 */
public class BoucleAffichage extends Boucleur{
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000/120);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Méthode qui appelle tout les observeurs sur la boucle
            beep();
        }
    }
}
