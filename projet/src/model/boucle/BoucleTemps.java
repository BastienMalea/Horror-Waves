package model.boucle;

public class BoucleTemps extends Boucleur{

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            beep();
        }
    }
}
