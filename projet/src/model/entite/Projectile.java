package model.entite;

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

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    public int getDirection(){
        return direction;
    }
}
