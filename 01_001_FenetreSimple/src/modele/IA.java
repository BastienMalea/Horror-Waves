package modele;

public abstract class IA extends Observeur{

    protected MAAnager manager:

    public IA(Manager m){
        manager=m;
    }
    public abstract void  calculerDeplacementMechant();

    @Override
    public void update(){
        calculerDeplacementMechant();
    }

}
