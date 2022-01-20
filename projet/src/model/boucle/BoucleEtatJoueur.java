package model.boucle;

public class BoucleEtatJoueur extends Boucleur{
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            beep();
        }
    }
}
