package modele.item;

public class Munition extends Item {
    private int quantite;

    public Munition(String nom, String img, int quantite){
        super(nom, img);
        this.quantite = quantite;
    }

    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }


    @Override
    public String toString() {
        String n = this.getNom();
        return "Munition{" +
                "nom='" + n + "'" +
                ", quantite=" + quantite +
                '}';
    }
}
