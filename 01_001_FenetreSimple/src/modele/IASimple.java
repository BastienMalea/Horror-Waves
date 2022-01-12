package modele;

public class IASimple extends IA{
    public void calculerDeplacementMechant(){
        m.deplacerMechant(Direction.BAS);
    }

    public IASimple(Manager m)
    {
        super(m);
    }
}
