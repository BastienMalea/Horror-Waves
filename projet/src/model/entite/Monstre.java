package model.entite;

public class Monstre extends Personnage{
    private int type;

    public Monstre(double x, double y, double hauteur, double largeur, double ratioHitBoxX, double ratioHitBoxY, int type) {
        super(x, y, hauteur, largeur, ratioHitBoxX, ratioHitBoxY);
        this.type = type;
    }

    public int getType(){
        return type;
    }
}
