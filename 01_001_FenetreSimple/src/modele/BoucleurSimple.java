package modele;

public class BoucleurSimple extends Boucleur{
    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(500);
            }
            catch (InterruptedException e){
                break;
            }
            beep();
        }
    }

}
