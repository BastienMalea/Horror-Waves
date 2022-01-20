package model.entite;

public class Monstre extends Personnage{
    private int type;

    public Monstre(double x, double y, double hauteur, double largeur, double ratioHitBoxX, double ratioHitBoxY, int pv, int type) {
        super(x, y, hauteur, largeur, ratioHitBoxX, ratioHitBoxY, pv);
        this.type = type;
    }

    public int getType() {
        return type;
    }

}
