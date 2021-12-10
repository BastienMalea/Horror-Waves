package modele.item;

public class Power extends Item {
    private String effet;
    private float multiplier;
    private int tempsActif;

    public Power(String nom, String img, String effet, float multiplier, int tempsActif) {
        super(nom, img);
        this.effet=effet;
        this.multiplier=multiplier;
        this.tempsActif=tempsActif;
    }

    public String getEffet() {
        return effet;
    }
    public void setEffet(String effet) {
        this.effet = effet;
    }

    public float getMultiplier() {
        return multiplier;
    }
    public void setMultiplier(float multiplier) {
        this.multiplier = multiplier;
    }

    public int getTempsActif() {
        return tempsActif;
    }
    public void setTempsActif(int tempsActif) {
        this.tempsActif = tempsActif;
    }



    @Override
    public String toString() {
        String n = this.getNom();
        return "Power{" +
                "nom ='" + n +"' "+
                "effet='" + effet + '\'' +
                ", multiplier=" + multiplier +
                ", tempsActif=" + tempsActif +
                '}';
    }
}
