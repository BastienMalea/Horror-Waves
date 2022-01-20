package model.boucle;

public class BoucleEtatJoueur extends Boucleur{
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            beep();
        }
    }
}
