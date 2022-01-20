package model.boucle;

/**
 * Boucle qui gérera le timer
 */
public class BoucleTemps extends Boucleur{

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Méthode qui appelle tout les observeurs sur la boucle
            beep();
        }
    }
}
