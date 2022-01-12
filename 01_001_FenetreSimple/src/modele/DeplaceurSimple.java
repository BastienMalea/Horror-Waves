package modele;


public class DeplaceurSimple extends Deplaceur{

    private final int STEP=10;

    @Override
    public void deplacerHaut(Entite e) {
        if(!collisionneur.isCollision(e.getX(), e.getY()-STEP, e))
        e.setY(e.getY()-10);
    }

    @Override
    public void deplacerBAs(Entite e) {
        //Pareil que deplacerHaut
    }

    @Override
    public void deplacerGauche(Entite e) {

    }
}
