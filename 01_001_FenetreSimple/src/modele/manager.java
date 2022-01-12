package modele;

public class manager {
    private Entite persoPrincipal = new Personnage();
    private Deplaceur deplaceur = new DeplaceurSimple();
    private Collisionneur collisionneur=new CollisionneurSimple();
    private Entite mechant=new Mechant(40,40);
    private Boucleur leBoucleur = new BoucleurSimple();


    public Manager(){
        var ia= new IASimple();
        leBoucleur.ajouterObservateur(ia);
        new Thread(leBoucleur).start();
    }

    public Entite getPersoPrincipalr(){
        return persoPrincipal;
    }


    public void deplacerPersonnagePrincipale(KeyCode code)
    {
        switch(code){
            case Up : deplaceur.deplacerHaut(persoPrincipal.colisionneur); break;
            case DOWN : deplaceur.deplacerHaut(persoPrincipal); break;
            case LEFT : deplaceur.deplacerHaut(persoPrincipal()); break;
            case RIGHT : deplaceur.deplacerHaut(persoPrincipal()); break;

        }
    }

    public Collisionneur getCollisionneur(){
        return collisionneur;
    }

    public deplacerMechant(Direction d){
        switch(d){
            case HAUT : deplaceur.deplacerHaut(mechant.colisionneur); break;
            case BAS : deplaceur.deplacerHaut(mechant()); break;
            case GAUCHE : deplaceur.deplacerHaut(mechant()); break;
            case DROITE : deplaceur.deplacerHaut(mechant()); break;

        }
    }

    public Entite getMechant(){
        return mechant;
    }
}
