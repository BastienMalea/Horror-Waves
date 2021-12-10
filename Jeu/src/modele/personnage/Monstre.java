package modele.personnage;

import modele.item.Arme;
import modele.item.typeArme;

public class Monstre extends Personnage {
    private int dmg;

    public Monstre(String nom, int pv, int posX, int posY, int vitesse, int dmg) {
        super(nom, pv, posX, posY, vitesse, new Arme(typeArme.MELEE, "lien vers image", "poing", 1, -1, 1));
        this.dmg = dmg;
    }

    public int getDmg() {
        return dmg;
    }
    public void setDmg(int dmg) {
        this.dmg = dmg;
    }



    @Override
    public String toString() {
        String la = super.afficherListeArme(super.getListeArme());
        return "Monstre{" +
                "nom='" + getNom() + '\'' +
                ", dmg=" + getDmg() +
                ", pv=" + getPv() +
                ", vitesse=" + getVitesse() +
                ", Arme =" + la +
                '}';
    }
}
