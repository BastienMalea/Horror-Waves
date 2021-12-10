package modele;

import java.util.Map;
import java.util.TreeMap;

public class Joueur extends Personnage {

        private TreeMap<Integer, Arme> listeArme;
    private int munitions;

    public Joueur(String nom, int pv, int posX, int posY, int vitesse, int munitions) {
        super(nom, pv, posX, posY, vitesse);
        this.munitions=munitions;
        this.listeArme = new TreeMap<Integer, Arme>();
        listeArme.put(0, new Arme(typeArme.MELEE, "poing", 1, -1, 1));
    }

    public int getMunitions() {
        return munitions;
    }

    public void setMunitions(int munitions) {
        this.munitions = munitions;
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
        String la = afficherListeArme(listeArme);
        return "Joueur {" +
                "nom='" + getNom() + '\'' +
                ", pv=" + getPv() +
                ", x=" + getX() +
                ", y=" + getY() +
                ", y=" + getVitesse() +
                ", Armes =" + la +
                '}';
    }
}
