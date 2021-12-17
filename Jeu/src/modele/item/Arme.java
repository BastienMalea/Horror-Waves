package modele.item;

public class Arme extends Item {

    private typeArme type;
    private int dmg;
    private int munitions;
    private int portee;


    public Arme(typeArme type, String img, String nom, int dmg, int munitions, int portee) {
        super(nom, img);
        this.type = type;
        this.dmg = dmg;
        this.munitions = munitions;
        this.portee = portee;
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

    public typeArme getType() {
        return type;
    }
    public void setType(typeArme type) {
        this.type = type;
    }

    @Override
    public String toString(){
        return "Arme{" +
                "nom='" + getNom() + "' " +
                "type='" +getType() +"' " +
                ", dmg=" + dmg +
                ", munitions=" + munitions +
                ", portee=" + portee +
                '}';
    }
}
