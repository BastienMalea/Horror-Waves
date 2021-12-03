package modele;

public class Monstre {
    private String nom;
    private int dmg;
    private int pv;
    private int vitesse;

    public Monstre(String nom, int dmg, int pv, int vitesse) {
        this.nom = nom;
        this.dmg = dmg;
        this.pv = pv;
        this.vitesse = vitesse;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDmg() {
        return dmg;
    }
    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getPv() {
        return pv;
    }
    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getVitesse() {
        return vitesse;
    }
    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    @Override
    public String toString() {
        return "Monstre{" +
                "nom='" + nom + '\'' +
                ", dmg=" + dmg +
                ", pv=" + pv +
                ", vitesse=" + vitesse +
                '}';
    }
}
