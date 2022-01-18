package model.boucle;

public class BoucleAffichage extends Boucleur{
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000/120);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            beep();
        }
    }
}
