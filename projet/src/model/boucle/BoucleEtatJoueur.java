package model.boucle;


/**
 * Boucle qui gérera l'état d'un joueur (Pts De Vies)
 */
public class BoucleEtatJoueur extends Boucleur{
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Méthode qui appelle tout les observeurs sur la boucle
            beep();
        }
    }
}
