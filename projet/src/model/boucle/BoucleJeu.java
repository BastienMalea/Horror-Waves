package model.boucle;

import java.util.Random;

public class BoucleJeu extends Boucleur{
    private int max = 3;
    private int multiplicateur = 1000;
    private int nbGen = 0;

    @Override
    public void run() {
        while(true){
            Random rn = new Random();
            int i = rn.nextInt((max-0)+1)+0;
            try {
                Thread.sleep((Math.abs(i)+2)*multiplicateur);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            beep();
            nbGen++;
            switch(nbGen){
                case 3: setMax(2); break;
                case 6: setMax(1); break;
                case 10: setMultiplicateur(700); break;
                case 13: setMultiplicateur(500); break;
                case 16: setMultiplicateur(200); break;
                case 30: setMultiplicateur(100); break;
                case 50: setMultiplicateur(50); break;
                default: break;
            }
        }
    }

    public void setMax(int max){
        this.max = max;
    }

    public int getMax(){
        return max;
    }

    public void setMultiplicateur(int multiplicateur){
        this.multiplicateur = multiplicateur;
    }

    public int getMultiplicateur(){
        return multiplicateur;
    }
}
