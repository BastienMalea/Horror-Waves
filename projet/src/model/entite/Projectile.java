package model.entite;

/**
 * Classe projectile du jeu
 */
public class Projectile extends Personnage{
    private float a;
    private float b;
    private int direction;


    public Projectile(double x, double y, double hauteur, double largeur, double ratioHitBoxX, double ratioHitBoxY, float a, float b, int direction){
        super(x, y, hauteur, largeur, ratioHitBoxX, ratioHitBoxY, 0);
        this.a = a;
        this.b = b;
        this.direction = direction;
    }

    /**
     * Getter de la variable a pour l'équation de la fonction affine ax+b
     * @return
     */
    public float getA() {
        return a;
    }

    /**
     * Getter de la variable b pour l'équation de la fonction affine ax+b
     * @return
     */

    public float getB() {
        return b;
    }

    /**
     * Getter de la direction du projectile
     * @return
     */

    public int getDirection(){
        return direction;
    }
}
