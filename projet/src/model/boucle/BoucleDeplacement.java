package model.boucle;

public class BoucleDeplacement extends Boucleur{
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            beep();
        }
    }
}
