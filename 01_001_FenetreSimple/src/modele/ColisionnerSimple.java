package modele;

public class ColisionnerSimple extends Collisionneur{


    private final int OFFSET = 15;
    @Override
    public boolean isCollision(double x, double y, Entite e) {
        return(if(x<0 || x> getLargeurFenetre()-e.getLargeur()-OFFSET || y <0 || y>getHauteurFenetre()-e.getHauteur()-OFFSET););
    }
}
