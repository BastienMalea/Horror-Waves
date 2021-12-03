package modele;

public class Arme {
    private String nom;
    private int dmg;
    public interface Collection<Munition>{};
    private int portee;

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

    public int getPortee() {
        return portee;
    }

    public void setPortee(int portee) {
        this.portee = portee;
    }

    public Arme(String nom, int dmg, int portee) {
        this.nom = nom;
        this.dmg = dmg;
        this.portee = portee;
    }
}
