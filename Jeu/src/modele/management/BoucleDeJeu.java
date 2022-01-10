package modele.management;

import java.util.Observable;

public class BoucleDeJeu extends Observable implements Runnable{

    @Override
    public void run(){
        while(true) {
            //System.out.println("beep");
            setChanged();
            notifyObservers();

            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
