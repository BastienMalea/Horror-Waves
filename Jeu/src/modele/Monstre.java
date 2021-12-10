package modele;

import java.util.Map;
import java.util.TreeMap;

public class Monstre extends Personnage {
    private int dmg;
    private TreeMap<Integer, Arme> listeArme;  // Est ce qu'on a besoin de faire une TreeMap étant donné qu'il a une seule arme

    public Monstre(String nom, int dmg, int pv, int vitesse, int posX, int posY) {
        super(nom, pv, posX, posY, vitesse);
        this.dmg = dmg;
        this.listeArme = new TreeMap<Integer, Arme>();
        listeArme.put(0, new Arme(typeArme.MELEE, "poing", 1, -1, 1));
    }

    public int getDmg() {
        return dmg;
    }
    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public String afficherListeArme(TreeMap<Integer, Arme> listeArme){
        StringBuilder str = new StringBuilder();
        for(Map.Entry<Integer, Arme> entry : listeArme.entrySet()){
            str.append(" ");
            str.append(entry.getValue().getNom());
            str.append(" :");
            str.append(entry.getValue().getType());
        }
        return str.toString();
    }


    @Override
    public String toString() {
        String la=afficherListeArme(listeArme);
        return "Monstre{" +
                "nom='" + getNom() + '\'' +
                ", dmg=" + dmg +
                ", pv=" + getPv() +
                ", vitesse=" + getVitesse() +
                ", Arme =" + la +
                '}';
    }
}
