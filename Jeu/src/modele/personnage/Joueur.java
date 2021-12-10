package modele.personnage;

import modele.item.Arme;
import modele.item.typeArme;

public class Joueur extends Personnage {
    private int munitions;

    public Joueur(String nom, int pv, int posX, int posY, int vitesse, int munitions) {
        super(nom, pv, posX, posY, vitesse, new Arme(typeArme.MELEE, "lien vers image", "poing", 1, -1, 1));
        this.munitions=munitions;
    }

    public int getMunitions() {
        return munitions;
    }
    public void setMunitions(int munitions) {
        this.munitions = munitions;
    }



    @Override
    public String toString() {
        String la = super.afficherListeArme(super.getListeArme());
        return "Joueur {" +
                "nom='" + getNom() + '\'' +
                ", pv=" + getPv() +
                ", x=" + getX() +
                ", y=" + getY() +
                ", vitesse=" + getVitesse() +
                ", Armes =" + la +
                '}';
    }
}
