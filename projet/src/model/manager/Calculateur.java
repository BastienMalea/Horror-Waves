package model.manager;

public class Calculateur {
    private float a;
    private float b;
    private double x;

    public Calculateur(){}

    /**
     * actualiser la fonction affine du viseur actuel
     * @param xJoueur
     * @param yJoueur
     * @param xMouse
     * @param yMouse
     */
    public void updateCalculateur(double xJoueur, double yJoueur, double xMouse, double yMouse){
        a = ((float)yMouse - (float)yJoueur) / ((float)xMouse - (float)xJoueur);
        b = (a*(-1) * (float)xMouse + (float)yMouse);
    }

    /**
     * calculer la coordonnée x du point de fin de ligne du viseur
     * @param xJoueur
     * @param xMouse
     * @return double
     */
    public double calculPosEndLineX(double xJoueur, double xMouse){
        if(Float.isInfinite(a)){
            this.x = xMouse;
            return xMouse;
        }
        if(xJoueur <= xMouse){
            this.x = 1500;
            return 1500;
        }
        if(xJoueur >= xMouse){
            this.x = -1500;
            return -1500;
        }

        this.x = xMouse;
        return xMouse;
    }

    /**
     * calculer la coordonnée y du point de fin de ligne du viseur
     * @param yJoueur
     * @param yMouse
     * @return
     */
    public double calculPosEndLineY(double yJoueur, double yMouse){
        if(Float.isInfinite(a) && yJoueur < yMouse){
            return 450;
        }
        if(Float.isInfinite(a) && yJoueur > yMouse){
            return -450;
        }
        return a*x+b;
    }

    /**
     * calculer la coordonnée y d'un projectile
     * @param aP
     * @param bP
     * @param xP
     * @return
     */
    public double calculProjectileY(float aP, float bP, double xP){
        return aP*xP+bP;
    }

    /**
     * retourne le coeficient directeur
     * @return
     */
    public float getA() {
        return a;
    }

    /**
     * retourne l'ordonnée à l'origine
     * @return
     */
    public float getB() {
        return b;
    }
}
