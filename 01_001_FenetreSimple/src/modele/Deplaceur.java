package modele;

public abstract class Deplaceur {
    public abstract void deplacerHaut(Entite e, Collisionneur c);
    public abstract void deplacerBAs(Entite e, Collisionneur c);
    public abstract void deplacerGauche(Entite e, Collisionneur c);
    public abstract void deplacerDroite(Entite e, Collisionneur c);
}
