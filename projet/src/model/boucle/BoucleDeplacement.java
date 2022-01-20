package model.boucle;


/**
 * Classe qui gérera tout les déplacements des Personnages
 */
public class BoucleDeplacement extends Boucleur{
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Méthode qui appelle tout les observeurs sur la boucle
            beep();
        }
    }
}
