package modele;

public class Arme {
    private String nom;
    private int dmg;
    private int munitions;
    private int portee;

    public Arme(String nom, int dmg, int munitions, int portee) {
        this.nom = nom;
        this.dmg = dmg;
        this.munitions = munitions;
        this.portee = portee;
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

    public int getMunitions() { return munitions; }
    public void setMunitions(int munitions) { this.munitions = munitions; }

    public int getPortee() {
        return portee;
    }
    public void setPortee(int portee) {
        this.portee = portee;
    }




    @Override
    public String toString(){
        return "Arme{" +
                "nom='" + nom + "'" +
                ", dmg=" + dmg +
                ", munitions=" + munitions +
                ", portee=" + portee +
                '}';
    }
}
