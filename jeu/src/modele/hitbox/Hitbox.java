package modele.hitbox;

import modele.item.Arme;

import java.util.Map;
import java.util.TreeMap;

public class Hitbox {
    private TreeMap<Integer, Rectangle> listeRectangle;

    public Hitbox(){
        this.listeRectangle = new TreeMap<Integer, Rectangle>();
    }


    public TreeMap<Integer, Rectangle> getListeRectangle() {
        return listeRectangle;
    }
    public void setListeRectangle(TreeMap<Integer, Rectangle> listeRectangle) {
        this.listeRectangle = listeRectangle;
    }

    public void addRectangle(int hauteur, int largeur){
        listeRectangle.put(listeRectangle.size(), new Rectangle(hauteur, largeur));
    }


    public String afficherListeRectangle(TreeMap<Integer, Rectangle> listeRectangle){
        StringBuilder str = new StringBuilder();
        for(Map.Entry<Integer, Rectangle> entry : listeRectangle.entrySet()){
            str.append(" Rectangle");
            str.append(entry.getKey());
            str.append("(");
            str.append(entry.getValue().getHauteur());
            str.append(";");
            str.append(entry.getValue().getLargeur());
            str.append(")");
        }
        return str.toString();
    }


    @Override
    public String toString(){
        String lr = this.afficherListeRectangle(listeRectangle);
        return "Hibox : " + lr;
    }
}
