package modele;

public class HitBox {
    private int hauteur;
    private int largeur;

    public HitBox(int hauteur, int largeur){
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    public int getHauteur() {
        return hauteur;
    }
    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getLargeur() {
        return largeur;
    }
    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }


}
