package modele;

// Me rappeler plus si c'était abstract ou pas

public class Item {
    private String nom;

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public Item(String nom){
        this.nom = nom;
    }
}
