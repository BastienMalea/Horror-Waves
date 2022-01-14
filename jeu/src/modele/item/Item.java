package modele.item;

// Me rappeler plus si c'était abstract ou pas

public class Item {
    private String nom;
    private String img;

    public Item(String nom, String img) {
        this.nom = nom;
        this.img = img;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getString() { return img; }
    public void setString(String img) { this.img = img; }

}
