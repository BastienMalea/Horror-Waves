package modele;

public class Munition extends Item{
    private int quantite;

    public Munition(String nom, int quantite){
        super(nom);
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
